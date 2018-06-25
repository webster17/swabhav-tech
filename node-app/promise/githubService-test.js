const GithubService = require('./githubService');

const githubService = new GithubService();

resolve = function(user){
    console.log();
    console.log("User:\nId: "+user.id);
    console.log("Name: "+user.name);
}

reject = function(err){
    console.log('Error: '+err.message);
}

githubService.getUser('santosh').then(user=>{
    console.log("User:\nId: "+user.id+" \tName: "+user.name);
    return githubService.getRepositories(user);
},reject).then(repositories=>{
    console.log("\nRepository:");
    for(let i in repositories)
        console.log("Id: "+repositories[i].id+" \tName: "+repositories[i].name);
    return githubService.getCommits(repositories[0]);
},reject).then(commits=>{
    console.log("\nCommits:");
    commits.map(commit=>console.log(commit));
},reject);
