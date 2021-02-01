
val spacecraftList = listOf(
  Spacecraft("Sputnik 1", "1957-10-04", "1957-10-26", "https://upload.wikimedia.org/wikipedia/commons/b/be/Sputnik_asm.jpg", "https://en.wikipedia.org/wiki/Sputnik_1"),
  Spacecraft("Sputnik 2", "1957-11-03", "1958-04-14", "https://upload.wikimedia.org/wikipedia/commons/3/33/Laika_ac_Sputnik_2_Replica_%286995685051%29.jpg", "https://en.wikipedia.org/wiki/Sputnik_2"),
  Spacecraft("Explorer 1", "1958-02-01", "1958-05-23", "https://upload.wikimedia.org/wikipedia/commons/7/73/Explorer1.jpg", "https://en.wikipedia.org/wiki/Explorer_1"),
  Spacecraft("Vostok 1", "1961-04-12", "1961-04-12", "https://upload.wikimedia.org/wikipedia/commons/d/df/Vostok_spacecraft.jpg", "https://en.wikipedia.org/wiki/Vostok_1"),
  Spacecraft("Salyut 1", "1971-04-19", "1971-10-11", "https://upload.wikimedia.org/wikipedia/en/c/cc/Salyut_1.jpg", "https://en.wikipedia.org/wiki/Salyut_1"),
  Spacecraft("Skylab", "1973-05-14", "1996-07-11", "https://upload.wikimedia.org/wikipedia/commons/0/07/Skylab_%28SL-4%29.jpg", "https://en.wikipedia.org/wiki/Skylab"),
  Spacecraft("Mir", "1986-02-20", "2001-03-23", "https://upload.wikimedia.org/wikipedia/commons/0/09/Mir_Space_Station_viewed_from_Endeavour_during_STS-89.jpg", "https://en.wikipedia.org/wiki/Mir"),
  Spacecraft("Hubble Space Telescope", "1990-04-24", "N/A", "https://upload.wikimedia.org/wikipedia/commons/3/3f/HST-SM4.jpeg", "https://en.wikipedia.org/wiki/Hubble_Space_Telescope"),
  Spacecraft("Compton Gamma Ray Observatory", "1991-04-05", "2000-06-04", "https://upload.wikimedia.org/wikipedia/commons/d/d9/CGRO_s37-96-010.jpg", "https://en.wikipedia.org/wiki/Compton_Gamma_Ray_Observatory"),
  Spacecraft("Solar and Heliospheric Observatory", "1995-12-02", "N/A", "https://upload.wikimedia.org/wikipedia/commons/6/6f/NASA_SOHO_spacecraft.png", "https://en.wikipedia.org/wiki/Solar_and_Heliospheric_Observatory"),
  Spacecraft("Cassini–Huygens", "1997-10-15", "2017-09-15", "https://upload.wikimedia.org/wikipedia/commons/b/b2/Cassini_Saturn_Orbit_Insertion.jpg", "https://en.wikipedia.org/wiki/Cassini%E2%80%93Huygens"),
  Spacecraft("International Space Station", "1998-11-20", "N/A", "https://upload.wikimedia.org/wikipedia/commons/0/04/International_Space_Station_after_undocking_of_STS-132.jpg", "https://en.wikipedia.org/wiki/International_Space_Station"),
  Spacecraft("Chandra X-ray Observatory", "1999-07-23", "N/A", "https://upload.wikimedia.org/wikipedia/commons/f/fd/Chandra_artist_illustration.jpg", "https://en.wikipedia.org/wiki/Chandra_X-ray_Observatory"),
  Spacecraft("Shenzhou 1", "1999-11-19", "1999-11-20", "https://upload.wikimedia.org/wikipedia/commons/9/9d/Post_S-7_Shenzhou_spacecraft.png", "https://en.wikipedia.org/wiki/Shenzhou_1"),
  Spacecraft("XMM-Newton", "1999-12-10", "N/A", "https://upload.wikimedia.org/wikipedia/commons/4/4a/XMM-Newton_spacecraft_model.png", "https://en.wikipedia.org/wiki/XMM-Newton"),
  Spacecraft("Spitzer Space Telescope", "2003-08-25", "2020-01-30", "https://upload.wikimedia.org/wikipedia/commons/8/8d/Spitzer_space_telescope.jpg", "https://en.wikipedia.org/wiki/Spitzer_Space_Telescope"),
  Spacecraft("Rosetta", "2004-03-02", "2016-09-30", "https://upload.wikimedia.org/wikipedia/commons/9/9a/Rosetta_spacecraft_model.png", "https://en.wikipedia.org/wiki/Rosetta_(spacecraft)"),
  Spacecraft("Tiangong-1", "2011-09-29", "2018-04-02", "https://upload.wikimedia.org/wikipedia/commons/6/64/Tiangong_1_drawing_%28cropped%29.png", "https://en.wikipedia.org/wiki/Tiangong-1"),
  Spacecraft("Gaia", "2013-12-19", "N/A", "https://upload.wikimedia.org/wikipedia/en/0/01/Gaia_spacecraft.jpg", "https://en.wikipedia.org/wiki/Gaia_(spacecraft)"),
  Spacecraft("James Webb Space Telescope", "2021-10-31", "N/A", "https://upload.wikimedia.org/wikipedia/commons/4/47/James_Webb_Space_Telescope_2009_top.jpg", "https://en.wikipedia.org/wiki/James_Webb_Space_Telescope")
)

val landerList = listOf(
  Spacecraft("Apollo Lunar Module", "1968-01-22", "1972-12-15", "https://upload.wikimedia.org/wikipedia/commons/2/2a/Apollo16LM.jpg", "https://en.wikipedia.org/wiki/Apollo_Lunar_Module"),
  Spacecraft("Lunokhod 1", "1970-11-10", "1971-09-14", "https://upload.wikimedia.org/wikipedia/commons/7/79/Soviet_moonrover.JPG", "https://en.wikipedia.org/wiki/Lunokhod_1"),
  Spacecraft("Philae", "2004-03-02", "2015-07-09", "https://upload.wikimedia.org/wikipedia/commons/9/95/Philae_lander_%28transparent_bg%29.png", "https://en.wikipedia.org/wiki/Philae_(spacecraft)"),
  Spacecraft("Curiosity", "2011-11-26", "N/A", "https://upload.wikimedia.org/wikipedia/commons/f/f3/Curiosity_Self-Portrait_at_%27Big_Sky%27_Drilling_Site.jpg", "https://en.wikipedia.org/wiki/Curiosity_(rover)")
)

val launcherList = listOf(
  Spacecraft("Proton", "1965-07-16", "N/A", "https://upload.wikimedia.org/wikipedia/commons/1/14/Proton_Zvezda_crop.jpg", "https://en.wikipedia.org/wiki/Proton_(rocket_family)"),
  Spacecraft("Soyuz", "1966-11-29", "N/A", "https://upload.wikimedia.org/wikipedia/commons/9/9a/Soyuz_TMA-9_launch.jpg", "https://en.wikipedia.org/wiki/Soyuz_(rocket_family)"),
  Spacecraft("Long March 3", "1984-01-29", "N/A", "https://en.wikipedia.org/wiki/Long_March_3A#/media/File:Chang_zheng_3a_launch.png", "https://en.wikipedia.org/wiki/Long_March_3"),
  Spacecraft("Polar Satellite Launch Vehicle", "1993-09-20", "N/A", "https://upload.wikimedia.org/wikipedia/commons/7/7c/PSLV_C-35_at_the_launch_pad_%28cropped%29.jpg", "https://en.wikipedia.org/wiki/Polar_Satellite_Launch_Vehicle"),
  Spacecraft("Ariane 5", "1996-06-04", "N/A", "https://upload.wikimedia.org/wikipedia/commons/3/3c/Ariane_5ES_with_ATV_4_on_its_way_to_ELA-3.jpg", "https://en.wikipedia.org/wiki/Ariane_5"),
  Spacecraft("Geosynchronous Satellite Launch Vehicle", "2001-04-18", "N/A", "https://upload.wikimedia.org/wikipedia/commons/a/a1/The_fully_integrated_GSLV-F05_carrying_INSAT-3DR_at_the_second_launch_pad.jpg", "https://en.wikipedia.org/wiki/Geosynchronous_Satellite_Launch_Vehicle"),
  Spacecraft("H-IIA", "2001-08-29", "N/A", "https://upload.wikimedia.org/wikipedia/commons/b/bf/H_IIA_No._F23_with_GPM_on_its_way_to_the_launchpad.jpg", "https://en.wikipedia.org/wiki/H-IIA"),
  Spacecraft("Atlas V", "2002-08-21", "N/A", "https://upload.wikimedia.org/wikipedia/commons/7/7e/Atlas_V%28401%29_launches_with_LRO_and_LCROSS_cropped.jpg", "https://en.wikipedia.org/wiki/Atlas_V"),
  Spacecraft("H-IIB", "2009-09-10", "2020-05-20", "https://upload.wikimedia.org/wikipedia/commons/e/e2/H-%E2%85%A1B%E3%83%AD%E3%82%B1%E3%83%83%E3%83%888%E5%8F%B7%E6%A9%9F.jpg", "https://en.wikipedia.org/wiki/H-IIB"),
  Spacecraft("Falcon 9", "2010-06-04", "N/A", "https://upload.wikimedia.org/wikipedia/commons/2/29/SpX_CRS-2_launch_-_further_-_cropped.jpg", "https://en.wikipedia.org/wiki/Falcon_9"),
  Spacecraft("Vega", "2012-02-13", "N/A", "https://upload.wikimedia.org/wikipedia/commons/3/31/Sentinel-2_and_vega.jpg", "https://en.wikipedia.org/wiki/Vega_(rocket)"),
  Spacecraft("Antares", "2013-04-13", "N/A", "https://upload.wikimedia.org/wikipedia/commons/1/1b/Cropped_NG-11_Launch.jpg", "https://en.wikipedia.org/wiki/Antares_(rocket)"),
  Spacecraft("Angara", "2014-07-23", "N/A", "https://upload.wikimedia.org/wikipedia/commons/0/0b/%D0%9F%D0%B5%D1%80%D0%B2%D1%8B%D0%B9_%D0%B8%D1%81%D0%BF%D1%8B%D1%82%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9_%D0%BF%D1%83%D1%81%D0%BA_%D1%80%D0%B0%D0%BA%D0%B5%D1%82%D1%8B-%D0%BD%D0%BE%D1%81%D0%B8%D1%82%D0%B5%D0%BB%D1%8F_%D1%82%D1%8F%D0%B6%D0%B5%D0%BB%D0%BE%D0%B3%D0%BE_%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0_%C2%AB%D0%90%D0%BD%D0%B3%D0%B0%D1%80%D0%B0-%D0%905%C2%BB_03.jpg", "https://en.wikipedia.org/wiki/Angara_(rocket_family)"),
  Spacecraft("Long March 5", "2016-11-03", "N/A", "https://upload.wikimedia.org/wikipedia/commons/4/4e/%E9%95%BF%E5%BE%81%E4%BA%94%E5%8F%B7%E9%81%A5%E4%BA%8C%E7%81%AB%E7%AE%AD%E8%BD%AC%E5%9C%BA.jpg", "https://en.wikipedia.org/wiki/Long_March_5"),
  Spacecraft("GSLV Mark III", "2017-06-05", "N/A", "https://upload.wikimedia.org/wikipedia/commons/a/a4/GSLV_Mk_III_D2_with_GSAT-29_on_Second_Launch_Pad_of_Satish_Dhawan_Space_Centre%2C_Sriharikota_%28SDSC_SHAR%29.jpg", "https://en.wikipedia.org/wiki/GSLV_Mark_III"),
  Spacecraft("Falcon Heavy", "2018-02-06", "N/A", "https://upload.wikimedia.org/wikipedia/commons/2/2b/Falcon_Heavy_cropped.jpg", "https://en.wikipedia.org/wiki/Falcon_Heavy"),
  Spacecraft("Vulcan Centaur", "Q4 2021", "N/A", "https://upload.wikimedia.org/wikipedia/commons/c/c9/ULA_Vulcan.png", "https://en.wikipedia.org/wiki/Vulcan_Centaur"),
  Spacecraft("Space Launch System", "November 2021", "N/A", "https://upload.wikimedia.org/wikipedia/commons/d/db/Sls_block1_on-pad_sunrisesmall.jpg", "https://en.wikipedia.org/wiki/Space_Launch_System"),
  Spacecraft("Ariane 6", "April 2022", "N/A", "https://upload.wikimedia.org/wikipedia/commons/f/f3/Ariane_62_and_64.svg", "https://en.wikipedia.org/wiki/Ariane_6")
)

const val spacecraftPath = "/spacecraft"
const val landersPath = "/landers"
const val launchersPath = "/launchers"
