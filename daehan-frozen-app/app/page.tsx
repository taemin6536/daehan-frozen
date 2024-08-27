import Image from "next/image";
import Header from "./Header";
import MainCarousel from "./MainCarousel";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between">
      <Header />
      <div className="border">
        <MainCarousel />
      </div>
      {/* <footer className="border">푸터</footer> */}
    </main>
  );
}
