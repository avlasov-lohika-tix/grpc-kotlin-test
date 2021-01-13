package main

import (
	"net/url"
	"testing"
)

func Test_prepareURL(t *testing.T) {
	type args struct {
		configuration *configuration
	}
	tests := []struct {
		name    string
		args    args
		want    url.URL
		wantErr bool
	}{
		{
			name: "Valid",
			args:
			struct {
				configuration *configuration
			}{
				configuration: &configuration{
					Port:     8081,
					Protocol: "http",
					Host:     "localhost",
				},
			},
			want: url.URL{
				Scheme: "http",
				Host:   "localhost:8081"},
			wantErr: false},
		{
			name: "Not matching protocol",
			args:
			struct {
				configuration *configuration
			}{
				configuration: &configuration{
					Port:     8081,
					Protocol: "invalid",
					Host:     "localhost",
				},
			},
			want:    url.URL{},
			wantErr: true},
		{
			name: "Not matching protocol",
			args:
			struct {
				configuration *configuration
			}{
				configuration: &configuration{
					Port:     8081,
					Protocol: "http://",
					Host:     "localhost",
				},
			},
			want:    url.URL{},
			wantErr: true},
		{
			name: "With host contains /",
			args:
			struct {
				configuration *configuration
			}{
				configuration: &configuration{
					Port:     8081,
					Protocol: "http",
					Host:     "/localhost/",
				},
			},
			want: url.URL{
				Scheme: "http",
				Host:   "localhost:8081"},
			wantErr: false},
		{
			name: "With invalid port",
			args:
			struct {
				configuration *configuration
			}{
				configuration: &configuration{
					Port:     -1,
					Protocol: "http",
					Host:     "localhost",
				},
			},
			want:    url.URL{},
			wantErr: true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := prepareURL(tt.args.configuration)
			if (err != nil) != tt.wantErr {
				t.Errorf("prepareURL() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if *got != tt.want {
				t.Errorf("prepareURL() got = %v, want %v", got, tt.want)
			}
		})
	}
}
