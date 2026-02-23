<script lang="ts">
  import svelteLogo from "./assets/svelte.svg";
  import Counter from "./lib/Counter.svelte";

  let message = $state("");

  async function loadMessage() {
    let response = await fetch("/api/hello");
    let data = (await response.json()) as Server.Message;
    message = data.text;
  }

  loadMessage();
</script>

<main>
  <div class="logos">
    <a href="https://kotlinlang.org" target="_blank" rel="noreferrer">
      <img src="/kotlin.svg" class="logo kotlin" alt="Kotlin Logo" />
    </a>
    <img src="/plus.svg" class="plus" alt="Plus" />
    <a href="https://svelte.dev" target="_blank" rel="noreferrer">
      <img src={svelteLogo} class="logo svelte" alt="Svelte Logo" />
    </a>
  </div>
  <h1>{message}</h1>

  <div class="card">
    <Counter />
  </div>

  <p class="read-the-docs">Click on the Kotlin and Svelte logos to learn more</p>
</main>

<style>
  .logos {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.5em;
  }

  .logo {
    height: 6em;
    padding: 1.5em;
    will-change: filter;
    transition: filter 300ms;
  }
  .logo:hover {
    filter: drop-shadow(0 0 2em #646cffaa);
  }
  .logo.svelte:hover {
    filter: drop-shadow(0 0 2em #ff3e00aa);
  }
  .logo.kotlin:hover {
    filter: drop-shadow(0 0 2em #7f52ffaa);
  }

  .plus {
    height: 1.5em;
    opacity: 0.6;
  }

  .read-the-docs {
    color: #888;
  }
</style>
