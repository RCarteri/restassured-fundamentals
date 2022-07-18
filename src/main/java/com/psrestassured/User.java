package com.psrestassured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // Para nao precisar criar todos os campos do body
public class User {
    public String login;
    public int id;
    @JsonProperty("public_repos") // pra não precisar dar o nome da variável de public_repos
    public int publicRepos;

    public int getPublicRepos() {
        return publicRepos;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
