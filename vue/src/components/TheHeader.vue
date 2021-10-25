<template>
  <div id="header">
      <router-link id="title" to="/">TE: Ticketing Experience</router-link>
      <router-link id="logout_link" v-if="$store.state.token" :to="{name : 'logout'}">logout</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#header{
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: rgb(142, 202, 230);
}

#title{
    font-size: 2.5rem;
    text-decoration: none;
    color: white;
    margin-top: 2rem;
    margin-bottom: 2rem;
    margin-left: 3rem;
}
#title:hover{
    color: rgb(251, 133, 0);
}
#logout_link{
    font-size: 2rem;
    text-decoration: none;
    color: white;
    margin-right: 10rem;
    margin-top: 2rem;
    margin-bottom: 2rem;
    
}
#logout_link:hover{
    color: rgb(251, 133, 0);
}
</style>