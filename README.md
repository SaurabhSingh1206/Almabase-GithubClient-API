# Almabase-GithubClient-API

An API built on top of Github API that exposes endpoints to process query of the following form. Given an organisation name, int n, and int m, find the n most popular repositories of a given organization on Github (Eg:[https://github.com/google](https://github.com/google)) based on the number of forks. For each such repo find the top m committees and their commit counts. 
The application is hosted on a [Heroku](https://www.heroku.com/) Server.

## Installation & SetUp

Fork and Clone the Github Repository into your local machine using:
```bash
git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
```
Install Maven (Ubuntu) :
```bash
sudo apt install maven
```
Install JDK (Ubuntu) :
```bash
sudo apt install default-jre
```
Navigate to the root of the project via command line and execute the command

```bash
mvn spring-boot:run
```
The CLI will run your application on the configured port and you can access it just like you would if you start the app in an IDE.

#### Note: This will work only if you have maven added to your pom.xml

## Usage

### Endpoint:



```python
https://api-almabase-githubclient.herokuapp.com/org
```
#### Method: 
POST Request - Data should be present in either XML or Json format. Should contain organization name, n, and m. E.g.
```json
{
   "organization" : "google",
   "n" : 2,
   "m" : 3
}
```
#### Returns : 
List of Repositories with their top m committees.

### Accessing the API Endpoint:-
The endpoint can be directly accessed using Postman, or can also be accessed from an application.

### Hosted on:-
The current application is hosted on Heroku Server.

## Technologies Used
Spring Boot

## External APIs Used
[Github API for Java](https://github-api.kohsuke.org/)

## Running Examples
1. 
### Request Body 

```json
{
	"organisationName" : "google",
	"n" : 1,
	"m" : 2
}
```
### Response Body

```json
[
    {
        "name": "it-cert-automation-practice",
        "owner": "google",
        "topKCommittees": [
            {
                "name": "Marga Manterola",
                "login": "marga-google",
                "email": "marga@google.com",
                "avatar_url": "https://avatars2.githubusercontent.com/u/3638713?v=4",
                "blog": "",
                "company": "Google",
                "followers": 25,
                "following": 0,
                "location": "Munich",
                "twitter_username": null,
                "type": "User",
                "commitCount": 3
            },
            {
                "name": "Margarita Manterola",
                "login": "margamanterola",
                "email": "marga@debian.org",
                "avatar_url": "https://avatars3.githubusercontent.com/u/8527483?v=4",
                "blog": "http://www.debian.org",
                "company": null,
                "followers": 45,
                "following": 0,
                "location": "Munich",
                "twitter_username": null,
                "type": "User",
                "commitCount": 1
            }
        ]
    }
]
```
2.
### Request Body
```json
{
	"organisationName" : "DiDi",
	"n" : 1,
	"m" : 2
}
```
### Response Body
```json
[
    {
        "name": "DoraemonKit",
        "owner": "didi",
        "topKCommittees": [
            {
                "name": null,
                "login": "yixiangboy",
                "email": "919727170@qq.com",
                "avatar_url": "https://avatars0.githubusercontent.com/u/13174496?v=4",
                "blog": "",
                "company": "滴滴出行",
                "followers": 688,
                "following": 8,
                "location": "杭州",
                "twitter_username": null,
                "type": "User",
                "commitCount": 391
            },
            {
                "name": "嘟囔",
                "login": "wanglikun7342",
                "email": "wanglikun7342@gmail.com",
                "avatar_url": "https://avatars0.githubusercontent.com/u/10217632?v=4",
                "blog": "",
                "company": "ByteDance",
                "followers": 28,
                "following": 1,
                "location": " Hangzhou, China",
                "twitter_username": null,
                "type": "User",
                "commitCount": 50
            }
        ]
    }
]
```

## Contributing
Saurabh Singh ([email](saurabhs1206@gmail.com)) - Author 
