# Embar Fall — Fabric Mod (Minecraft 1.21.11)

"Yanmış Topraklar" (Burnt Lands) temalı, volkanik bir biyom etrafında kurulu
bir Fabric modu. 10 yeni blok, ortaçağ-büyü tarzı eşyalar ve biyoma özgü
mob'lar içerir.

## İçerik

### 10 Blok
- Yanardağ Taşı (`volcanic_rock`)
- Kül Bloğu (`ash_block`) — düşen (gravity) blok
- Kömürleşmiş Kütük (`charred_log`) — eksene göre dönen kütük
- Kor Cevheri (`ember_ore`) — kırılınca **Kor Tozu** düşürür, hafif ışık yayar
- Ergimiş Obsidyen (`molten_obsidian`) — çok sert, ışık kaynağı
- Yanmış Toprak (`scorched_dirt`) — biyomun zemini
- Kükürt Kristali Bloğu (`sulfur_crystal_block`) — ışık yayan dekoratif blok
- Çatlak Bazalt (`cracked_basalt`)
- Kül Çimi Bloğu (`ashen_grass_block`) — üstü/yanı farklı dokulu "çim" bloğu
- Kor Feneri (`ember_lantern`) — güçlü ışık kaynağı

### Eşyalar (ortaçağ büyü tarzı)
- **Kor Asası** (`ember_wand`) — sağ tık ile küçük ateş topu fırlatır
- **Alev Tomarı** (`scroll_of_flames`) — kullanılınca Ateş Direnci + Hız verir
- **Kor Muskası** (`ember_amulet`) — üst düzey büyülü aksesuar (crafting ile üretilir)
- Kor Tozu, Kükürt Tozu, Kül Rünü — crafting hammaddeleri
- İki mob için spawn yumurtaları

### 12 Özel Kristal
Kalıcı (tüketilmeyen) büyülü taşlar. Sağ tık ile taşıyıcıya kısa süreli bir
etki verirler, ardından bir bekleme süresine girerler. Kül İskeleti ve Kor
Zombisi'nden düşük ihtimalle düşerler.

| Kristal | Etki |
|---|---|
| Kor Kristali | Ateş Direnci |
| Kül Kristali | Gece Görüşü |
| Kükürt Kristali | Hız |
| Magma Kristali | Güç |
| Obsidyen Kristali | Dayanıklılık (hasar azaltma) |
| Bazalt Kristali | Acele (kazma hızı) |
| Duman Kristali | Görünmezlik |
| Alev Kristali | Güç |
| Kömür Kristali | Acele |
| Volkanik Kristal *(nadir)* | Ateş Direnci |
| Anka Kristali *(epik)* | Yenilenme |
| Kanlı Kor Kristali *(epik)* | Güç |

### Mob'lar
- **Kül İskeleti** (`ash_skeleton`) — vanilla İskelet'i genişletir, ateşe
  bağışık, alevli ok atar. Yenilince ~%15 ihtimalle Kül Rünü düşürür.
- **Kor Zombisi** (`ember_zombie`) — vanilla Zombi'yi genişletir, ateşe
  bağışık, vurduğunda hedefi tutuşturur.
- Biyomda ayrıca **vanilla İskelet** ve az sayıda **Blaze** da spawn olur
  (hem yeni hem mevcut mob'lar bir arada).

### Biyom
`data/embarfall/worldgen/biome/burnt_lands.json` içinde tanımlı, sıcak/kuru
bir Overworld biyomu. `ModBiomes.java` bu biyomu Fabric Biome API üzerinden
Overworld üretimine ekler (kıyı/karasal iklim: kuru).

## Telefondan Derleme (GitHub Actions ile)

Bilgisayarsız, sadece telefon + tarayıcı ile derlemek için:

1. **GitHub hesabı aç** (ücretsiz) — github.com, tarayıcıdan.
2. **Yeni bir repo oluştur** — "New repository", adını `EmbarFall` koy, **Public**
   ya da **Private** fark etmez.
3. **Zip'i telefonunda aç (extract)** — Dosyalar/Files uygulamasında
   `EmbarFall.zip`'e uzun bas > "Sıkıştırmayı Aç / Extract" (iOS ve Android'de
   yerleşik olarak var).
4. Repo sayfasında **"Add file" > "Upload files"** butonuna bas, açtığın
   `EmbarFall` klasörünün **içindeki tüm dosya ve klasörleri** seç, sürükle-bırak
   ya da dosya seçiciyle yükle. (Klasör yapısını korumak için tarayıcının
   "klasör yükle" seçeneğini destekleyip desteklemediğine bak — Chrome
   masaüstünde var, mobilde bazen tek tek dosya seçmen gerekebilir. Alternatif:
   [GitHub Desktop](https://desktop.github.com/) yerine mobilde **Working Copy**
   (iOS) ya da **Termux + git** (Android) gibi bir git istemcisiyle tüm klasörü
   tek seferde push'layabilirsin.)
5. Commit'le ("Commit changes").
6. Repo'da **"Actions"** sekmesine git — `.github/workflows/build.yml` az önce
   yüklendiği için otomatik olarak bir derleme başlayacak (birkaç dakika sürer).
7. Derleme (çalışan iş) bitince üstüne tıkla, en altta **"Artifacts"**
   bölümünde `embarfall-jar` göreceksin — ona dokunup indir. İçinden çıkan
   `.jar` dosyası, `.minecraft/mods/` klasörüne (bilgisayarında ya da
   Android'de Pojav Launcher gibi bir launcher'ın mods klasörüne) koyulacak jar.

**Not:** Bu yöntemde asıl derleme GitHub'ın bulut sunucularında yapılıyor,
telefonun sadece dosyaları yüklüyor ve sonucu indiriyor — bu yüzden telefonun
gücü/işletim sistemi (Android/iOS) önemli değil.

### Alternatif: Android'de Termux ile telefonun kendi üzerinde derleme
Android kullanıyorsan [Termux](https://f-droid.org/packages/com.termux/) uygulamasıyla
telefonun üzerinde gerçekten derleme de yapılabilir (`pkg install openjdk-21 gradle git`
ardından `gradle build`), ama bu daha yavaş, depolama/RAM gerektirir ve kurulumu
GitHub Actions'a göre daha uğraştırıcıdır. iOS'ta bu şekilde bir seçenek yok.

## Nasıl Derlenir (Bilgisayardan)

1. [IntelliJ IDEA](https://www.jetbrains.com/idea/) kur (Community sürümü yeterli).
2. Bu klasörü IntelliJ'de "Open" ile aç; Gradle projesini otomatik tanıyacaktır.
3. **ÖNEMLİ:** `gradle.properties` içindeki `yarn_mappings` ve `fabric_version`
   değerlerini derlemeden önce https://fabricmc.net/develop adresinden
   1.21.11 için **güncel** değerlerle karşılaştır — bu dosyalar Fabric
   tarafından sık güncellenir ve buradaki değerler yazılma anı itibarıyladır.
4. Gradle senkronizasyonu bitince `Build > Build Project` çalıştır ya da
   terminalde `./gradlew build` komutunu kullan.
5. Üretilen `.jar` dosyası `build/libs/` klasöründe olacak; bunu
   `.minecraft/mods/` klasörüne kopyalayıp Fabric Loader + Fabric API ile
   oyunu başlat.

## Bilinmesi Gerekenler / Sınırlamalar

- **Bu proje bir ağ bağlantısı olmayan ortamda hazırlandığı için hiç
  derlenip test edilmedi.** Kod, 1.21.x döneminin tipik Yarn mapping
  isimlerine göre yazıldı; olası küçük API farkları için dosyalarda
  "NOT:" ile işaretlenmiş yorumlar bırakıldı (ör. `Item#use()` imzası,
  `ItemStack#damage()`, `SpawnEggItem` constructor'ı, `OverworldBiomes`
  metodları). IntelliJ'de kırmızı alt çizgi görürsen, IDE'nin önerdiği
  otomatik-tamamlamayla küçük bir düzeltme yeterli olacaktır.
- Dokular (`textures/`) Python ile **prosedürel olarak üretilmiş**
  yer tutuculardır (gerçek piksel-sanatı değil) — görünüm işlevsel ama
  sade; istersen bunları kendi 16x16 piksel sanatınla değiştirebilirsin.
- Biyomun "kendi zemin bloklarıyla" (Yanmış Toprak, Kül Çimi vb.) doğal
  olarak oluşması için Overworld'ün `surface_rule` (yüzey kuralları)
  dosyasının da düzenlenmesi gerekir — bu, vanilla'nın devasa
  `noise_settings/overworld.json` dosyasının bir kopyasını istiyor ve bu
  projeye dahil edilmedi. Şu an biyom; iklimi, mob spawn'larını, cevher
  ve dekor (kül, kütük, kristal) oluşumunu doğru şekilde tanımlıyor,
  ama zemin varsayılan olarak vanilla taş/toprak ile gelecektir. İstersen
  bir sonraki adımda bunu da ekleyebilirim.
- İki mob da mevcut İskelet/Zombi model ve animasyonlarını yeniden
  kullanıyor (sadece doku ve davranış değişti) — tamamen özgün bir 3D
  model istersen bu ayrı bir iş (Blockbench ile model + animasyon).

## Klasör Yapısı

```
EmbarFall/
  build.gradle, gradle.properties, settings.gradle
  src/main/java/com/embarfall/        -> ortak (sunucu+istemci) kod
  src/client/java/com/embarfall/      -> sadece istemci kodu (renderer'lar)
  src/main/resources/assets/embarfall -> dokular, modeller, dil dosyaları
  src/main/resources/data/embarfall   -> biyom, tarifler, loot table, worldgen
```
