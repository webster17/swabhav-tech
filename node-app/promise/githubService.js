var fileSystem = require("fs");

data = fileSystem.readFileSync('database.json');
database = JSON.parse(data.toString());

class GithubService {
    
    getUser(userName) {
        return new Promise(function (resolveFn, rejectFn) {
            for (let i in database.users)
                if (database.users[i].name === userName)
                    resolveFn(database.users[i]);
                else
                    rejectFn(new Error('User Not Found!'));
        });
    }

    getRepositories(user) {
        return new Promise(function (resolveFn, rejectFn) {
            if (user.hasOwnProperty('repositories'))
                resolveFn(user.repositories);
            else
                rejectFn(new Error('Repository Not Found!'));
        });
    }

    getCommits(repository){
        return new Promise(function (resolveFn, rejectFn){
            if(repository.hasOwnProperty('commits'))
                resolveFn(repository.commits);
            else
                rejectFn(new Error('Commits not found!'));z
        });
    }
}

module.exports = GithubService;