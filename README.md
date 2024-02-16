For Logging with Oath2Client . Firstly you should go to the "https://console.cloud.google.com/apis" . If you Login first time , you should set up Oauth consent screen. 
Then create credentials button . And enter your email which is your registration mail with google.
During this process there is "Authorized redirect URIs" section . You have to enter "http://localhost:8080/login/oauth2/code/google" this URL in empty section.
Then You should copy "Client id" and "Client secret" in Application.yaml which I mentioned
