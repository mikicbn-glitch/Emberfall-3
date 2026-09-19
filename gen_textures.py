import random
from PIL import Image

random.seed(42)

BASE = "src/main/resources/assets/embarfall/textures"

def noise_texture(path, base_color, variants, size=16, speckle=0.35, border=None):
    """base_color: (r,g,b); variants: list of (r,g,b) to randomly speckle in."""
    img = Image.new("RGB", (size, size))
    px = img.load()
    for y in range(size):
        for x in range(size):
            c = base_color
            if random.random() < speckle:
                c = random.choice(variants)
            px[x, y] = c
    if border:
        for x in range(size):
            px[x, 0] = border
            px[x, size - 1] = border
        for y in range(size):
            px[0, y] = border
            px[size - 1, y] = border
    img.save(path)

def cracked_texture(path, base_color, crack_color, size=16):
    img = Image.new("RGB", (size, size), base_color)
    px = img.load()
    # a few diagonal / jagged crack lines
    for _ in range(4):
        x, y = random.randint(0, size - 1), random.randint(0, size - 1)
        length = random.randint(6, 12)
        for _ in range(length):
            if 0 <= x < size and 0 <= y < size:
                px[x, y] = crack_color
            x += random.choice([-1, 0, 1])
            y += random.choice([0, 1])
    img.save(path)

def glow_texture(path, base_color, glow_color, size=16):
    img = Image.new("RGB", (size, size), base_color)
    px = img.load()
    for y in range(size):
        for x in range(size):
            if random.random() < 0.25:
                px[x, y] = glow_color
    img.save(path)

def item_icon(path, base_color, accent, shape="blob", size=16):
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    px = img.load()
    cx, cy = size // 2, size // 2
    if shape == "blob":
        for y in range(size):
            for x in range(size):
                d = ((x - cx) ** 2 + (y - cy) ** 2) ** 0.5
                if d < 5 + random.uniform(-1, 1):
                    px[x, y] = base_color + (255,)
                elif d < 6.5 and random.random() < 0.5:
                    px[x, y] = accent + (255,)
    elif shape == "wand":
        for i in range(12):
            x = 2 + i
            y = 13 - i
            px[x, y] = base_color + (255,)
            if 0 <= x + 1 < size:
                px[x + 1, y] = accent + (255,)
        px[13, 2] = accent + (255,)
        px[12, 3] = accent + (255,)
        px[13, 3] = (255, 255, 200, 255)
    elif shape == "scroll":
        for y in range(3, 13):
            for x in range(4, 12):
                px[x, y] = (222, 202, 165, 255)
        for x in range(4, 12):
            px[x, 3] = base_color + (255,)
            px[x, 12] = base_color + (255,)
        for y in range(5, 10):
            px[6, y] = accent + (255,)
    elif shape == "amulet":
        for y in range(2, 6):
            px[cx, y] = (120, 120, 120, 255)
        for y in range(size):
            for x in range(size):
                d = ((x - cx) ** 2 + (y - (cy + 2)) ** 2) ** 0.5
                if d < 4:
                    px[x, y] = base_color + (255,)
                elif d < 5 and random.random() < 0.6:
                    px[x, y] = accent + (255,)
    img.save(path)

# ---------- BLOCK TEXTURES ----------
noise_texture(f"{BASE}/block/volcanic_rock.png", (35, 33, 32), [(20, 18, 18), (60, 45, 30), (90, 40, 20)])
noise_texture(f"{BASE}/block/ash_block.png", (150, 148, 145), [(170, 168, 165), (120, 118, 115), (190, 188, 185)], speckle=0.4)
noise_texture(f"{BASE}/block/charred_log_top.png", (25, 20, 18), [(60, 30, 15), (10, 8, 8)], speckle=0.5)
noise_texture(f"{BASE}/block/charred_log_side.png", (30, 22, 18), [(55, 28, 14), (15, 10, 8), (90, 35, 15)], speckle=0.45)
noise_texture(f"{BASE}/block/ember_ore.png", (60, 55, 55), [(255, 120, 20), (200, 80, 10), (40, 38, 38)], speckle=0.22)
glow_texture(f"{BASE}/block/molten_obsidian.png", (18, 10, 25), (255, 110, 20))
noise_texture(f"{BASE}/block/scorched_dirt.png", (70, 60, 55), [(90, 75, 65), (50, 42, 38), (110, 60, 30)], speckle=0.35)
noise_texture(f"{BASE}/block/sulfur_crystal_block.png", (210, 190, 60), [(235, 215, 90), (180, 160, 40), (255, 240, 140)], speckle=0.4)
cracked_texture(f"{BASE}/block/cracked_basalt.png", (35, 34, 38), (10, 10, 12))
noise_texture(f"{BASE}/block/ashen_grass_block_top.png", (150, 145, 140), [(170, 165, 160), (120, 115, 110), (200, 90, 40)], speckle=0.4)
noise_texture(f"{BASE}/block/ashen_grass_block_side.png", (95, 70, 55), [(150, 145, 140), (70, 55, 45)], speckle=0.3)
glow_texture(f"{BASE}/block/ember_lantern.png", (60, 40, 25), (255, 160, 40))

# ---------- ITEM TEXTURES ----------
item_icon(f"{BASE}/item/ember_dust.png", (200, 90, 20), (255, 160, 60), shape="blob")
item_icon(f"{BASE}/item/sulfur_dust.png", (210, 190, 60), (255, 235, 130), shape="blob")
item_icon(f"{BASE}/item/ash_rune.png", (120, 115, 110), (60, 55, 55), shape="blob")
item_icon(f"{BASE}/item/ember_wand.png", (70, 45, 30), (255, 140, 30), shape="wand")
item_icon(f"{BASE}/item/scroll_of_flames.png", (140, 40, 10), (255, 120, 20), shape="scroll")
item_icon(f"{BASE}/item/ember_amulet.png", (200, 150, 30), (255, 90, 20), shape="amulet")

# spawn eggs (simple base+dots convention, generated as normal square icon)
def spawn_egg(path, base, dots):
    size = 16
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    px = img.load()
    cx, cy = size / 2, size / 2
    for y in range(size):
        for x in range(size):
            dx, dy = (x - cx) / 6.0, (y - cy) / 7.5
            if dx * dx + dy * dy < 1:
                px[x, y] = base + (255,)
    for _ in range(10):
        x, y = random.randint(3, 12), random.randint(3, 13)
        if px[x, y][3] > 0:
            px[x, y] = dots + (255,)
    img.save(path)

spawn_egg(f"{BASE}/item/ash_skeleton_spawn_egg.png", (74, 74, 74), (255, 122, 26))
spawn_egg(f"{BASE}/item/ember_zombie_spawn_egg.png", (92, 26, 0), (255, 157, 51))

# ---------- 12 OZEL KRISTAL ----------
def crystal_icon(path, core, edge, glow=False, size=16):
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    px = img.load()
    cx, cy = size / 2, size / 2
    # elmas/kristal gorunumlu bir sekil: ust ucu sivri, alt ucu sivri
    points_top = 2
    points_bottom = size - 2
    for y in range(size):
        for x in range(size):
            # basit "elmas" siluet testi
            half_w = 5 * (1 - abs((y - cy) / (cy - points_top + 0.01)))
            if abs(x - cx) < half_w and points_top <= y <= points_bottom:
                d = abs(x - cx) / (half_w + 0.01)
                if d < 0.45:
                    px[x, y] = core + (255,)
                else:
                    px[x, y] = edge + (255,)
    if glow:
        px[int(cx), int(cy) - 2] = (255, 255, 255, 255)
    img.save(path)

crystals = [
    ("ember_crystal",       (255, 110, 20),  (150, 40, 0),   False),
    ("ash_crystal",         (190, 188, 185), (110, 108, 105),False),
    ("sulfur_crystal",      (235, 215, 90),  (170, 150, 30), False),
    ("magma_crystal",       (255, 70, 20),   (120, 15, 0),   True),
    ("obsidian_crystal",    (60, 30, 90),    (20, 10, 30),   False),
    ("basalt_crystal",      (70, 68, 75),    (25, 24, 28),   False),
    ("smoke_crystal",       (170, 170, 180), (110, 110, 120),False),
    ("flame_crystal",       (255, 60, 10),   (180, 20, 0),   True),
    ("charcoal_crystal",    (40, 38, 38),    (10, 10, 10),   False),
    ("volcanic_crystal",    (200, 30, 10),   (40, 10, 10),   True),
    ("phoenix_crystal",     (255, 190, 60),  (255, 100, 20), True),
    ("blood_ember_crystal", (150, 10, 15),   (60, 0, 5),     True),
]

for name, core, edge, glow in crystals:
    crystal_icon(f"{BASE}/item/{name}.png", core, edge, glow=glow)

# ---------- ENTITY TEXTURES (64x32 vanilla skeleton/zombie layout) ----------
def entity_reskin(path, base_color, accent, width=64, height=32):
    img = Image.new("RGBA", (width, height), (0, 0, 0, 0))
    px = img.load()
    for y in range(height):
        for x in range(width):
            # only paint within rough vanilla UV regions so it's not fully blank;
            # simple approach: paint everything, unused UV space just won't be sampled badly.
            c = base_color
            if random.random() < 0.15:
                c = accent
            px[x, y] = c + (255,)
    img.save(path)

entity_reskin(f"{BASE}/entity/ash_skeleton.png", (210, 208, 205), (255, 130, 40))
entity_reskin(f"{BASE}/entity/ember_zombie.png", (60, 40, 30), (255, 110, 20))

print("Textures generated.")
