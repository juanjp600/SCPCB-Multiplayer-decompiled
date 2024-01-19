Function inititemtemplates%()
    Local local0.itemtemplates
    Local local1%
    local0 = createitemtemplate("Some SCP-420-J", "420", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0005, "", "", $00, $09, $00)
    local0\Field3 = $02
    createitemtemplate("Level 1 Key Card", "key1", "GFX\items\keycard.x", "GFX\items\INVkey1.jpg", "", 0.0004, "GFX\items\keycard1.jpg", "", $00, $09, $00)
    createitemtemplate("Level 2 Key Card", "key2", "GFX\items\keycard.x", "GFX\items\INVkey2.jpg", "", 0.0004, "GFX\items\keycard2.jpg", "", $00, $09, $00)
    createitemtemplate("Level 3 Key Card", "key3", "GFX\items\keycard.x", "GFX\items\INVkey3.jpg", "", 0.0004, "GFX\items\keycard3.jpg", "", $00, $09, $00)
    createitemtemplate("Level 4 Key Card", "key4", "GFX\items\keycard.x", "GFX\items\INVkey4.jpg", "", 0.0004, "GFX\items\keycard4.jpg", "", $00, $09, $00)
    createitemtemplate("Level 5 Key Card", "key5", "GFX\items\keycard.x", "GFX\items\INVkey5.jpg", "", 0.0004, "GFX\items\keycard5.jpg", "", $00, $09, $00)
    createitemtemplate("Playing Card", "misc", "GFX\items\keycard.x", "GFX\items\INVcard.jpg", "", 0.0004, "GFX\items\card.jpg", "", $00, $09, $00)
    createitemtemplate("Mastercard", "misc", "GFX\items\keycard.x", "GFX\items\INVmastercard.jpg", "", 0.0004, "GFX\items\mastercard.jpg", "", $00, $09, $00)
    createitemtemplate("Key Card Omni", "key6", "GFX\items\keycard.x", "GFX\items\INVkeyomni.jpg", "", 0.0004, "GFX\items\keycardomni.jpg", "", $00, $09, $00)
    local0 = createitemtemplate("SCP-860", "scp860", "GFX\items\key.b3d", "GFX\items\INVkey.jpg", "", 0.001, "", "", $00, $09, $00)
    local0\Field3 = $03
    local0 = createitemtemplate("Document SCP-079", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc079.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-895", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc895.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-860", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc860.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-860-1", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc8601.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("SCP-093 Recovered Materials", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc093rm.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-106", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc106.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Dr. Allok's Note", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc106_2.jpg", (1.0 / 400.0), "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Recall Protocol RP-106-N", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docRP.jpg", (1.0 / 400.0), "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-682", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc682.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-173", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc173.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-372", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc372.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-049", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc049.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-096", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc096.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-008", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc008.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-012", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc012.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-500", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc500.png", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-714", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc714.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-513", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc513.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-035", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc035.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("SCP-035 Addendum", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc035ad.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-939", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc939.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-966", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc966.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-970", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc970.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-1048", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1048.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-1123", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1123.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-1162", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1162.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-1499", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1499.png", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Incident Report SCP-1048-A", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1048a.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Drawing", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc1048.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Leaflet", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\leaflet.jpg", 0.003, "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Dr. L's Note", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docL1.jpg", (1.0 / 400.0), "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Dr L's Note", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docL2.jpg", (1.0 / 400.0), "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Blood-stained Note", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docL3.jpg", (1.0 / 400.0), "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Dr. L's Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INVbn.jpg", "GFX\items\docL4.jpg", (1.0 / 400.0), "GFX\items\BurntNoteTexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Dr L's Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INVbn.jpg", "GFX\items\docL5.jpg", (1.0 / 400.0), "GFX\items\BurntNoteTexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Scorched Note", "paper", "GFX\items\paper.x", "GFX\items\INVbn.jpg", "GFX\items\docL6.jpg", (1.0 / 400.0), "GFX\items\BurntNoteTexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Journal Page", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docGonzales.jpg", (1.0 / 400.0), "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Log #1", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\f4.jpg", 0.0017, "GFX\items\f4.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Log #2", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\f5.jpg", 0.0017, "GFX\items\f4.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Log #3", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\f6.jpg", 0.0017, "GFX\items\f4.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Strange Note", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docStrange.jpg", (1.0 / 400.0), "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Nuclear Device Document", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docNDP.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Class D Orientation Leaflet", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docORI.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Note from Daniel", "paper", "GFX\items\note.x", "GFX\items\INVnote2.jpg", "GFX\items\docdan.jpg", (1.0 / 400.0), "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INVbn.jpg", "GFX\items\bn.it", 0.003, "GFX\items\BurntNoteTexture.jpg", "", $00, $09, $00)
    local0\Field12 = burntnote
    local0\Field3 = $00
    local0 = createitemtemplate("Mysterious Note", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\sn.it", 0.003, "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Mobile Task Forces", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docMTF.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Security Clearance Levels", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docSC.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Object Classes", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docOBJC.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docRAND3.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Addendum: 5/14 Test Log", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docRAND2.jpg", 0.003, "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Notification", "paper", "GFX\items\paper.x", "GFX\items\INVnote.jpg", "GFX\items\docRAND1.jpg", 0.003, "GFX\items\notetexture.jpg", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Incident Report SCP-106-0204", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docIR106.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Ballistic Vest", "vest", "GFX\items\vest.x", "GFX\items\INVvest.jpg", "", 0.02, "GFX\items\Vest.png", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Heavy Ballistic Vest", "finevest", "GFX\items\vest.x", "GFX\items\INVvest.jpg", "", 0.022, "GFX\items\Vest.png", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Bulky Ballistic Vest", "veryfinevest", "GFX\items\vest.x", "GFX\items\INVvest.jpg", "", 0.025, "GFX\items\Vest.png", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Hazmat Suit", "hazmatsuit", "GFX\items\hazmat.b3d", "GFX\items\INVhazmat.jpg", "", 0.013, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Hazmat Suit", "hazmatsuit2", "GFX\items\hazmat.b3d", "GFX\items\INVhazmat.jpg", "", 0.013, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Heavy Hazmat Suit", "hazmatsuit3", "GFX\items\hazmat.b3d", "GFX\items\INVhazmat.jpg", "", 0.013, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("cup", "cup", "GFX\items\cup.x", "GFX\items\INVcup.jpg", "", 0.04, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Empty Cup", "emptycup", "GFX\items\cup.x", "GFX\items\INVcup.jpg", "", 0.04, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("SCP-500-01", "scp500", "GFX\items\pill.b3d", "GFX\items\INVpill.jpg", "", 0.0001, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("First Aid Kit", "firstaid", "GFX\items\firstaid.x", "GFX\items\INVfirstaid.jpg", "", 0.05, "", "", $00, $09, $00)
    local0 = createitemtemplate("Small First Aid Kit", "finefirstaid", "GFX\items\firstaid.x", "GFX\items\INVfirstaid.jpg", "", 0.03, "", "", $00, $09, $00)
    local0 = createitemtemplate("Blue First Aid Kit", "firstaid2", "GFX\items\firstaid.x", "GFX\items\INVfirstaid2.jpg", "", 0.03, "GFX\items\firstaidkit2.jpg", "", $00, $09, $00)
    local0 = createitemtemplate("Strange Bottle", "veryfinefirstaid", "GFX\items\eyedrops.b3d", "GFX\items\INVbottle.jpg", "", 0.002, "GFX\items\bottle.jpg", "", $00, $09, $00)
    local0 = createitemtemplate("Gas Mask", "gasmask", "GFX\items\gasmask.b3d", "GFX\items\INVgasmask.jpg", "", 0.02, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Gas Mask", "supergasmask", "GFX\items\gasmask.b3d", "GFX\items\INVgasmask.jpg", "", 0.021, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Heavy Gas Mask", "gasmask3", "GFX\items\gasmask.b3d", "GFX\items\INVgasmask.jpg", "", 0.021, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Origami", "misc", "GFX\items\origami.b3d", "GFX\items\INVorigami.jpg", "", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    createitemtemplate("Electronical components", "misc", "GFX\items\electronics.x", "GFX\items\INVelectronics.jpg", "", 0.0011, "", "", $00, $09, $00)
    local0 = createitemtemplate("Metal Panel", "scp148", "GFX\items\metalpanel.x", "GFX\items\INVmetalpanel.jpg", "", roomscale, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("SCP-148 Ingot", "scp148ingot", "GFX\items\scp148.x", "GFX\items\INVscp148.jpg", "", roomscale, "", "", $00, $09, $00)
    local0\Field3 = $02
    createitemtemplate("S-NAV 300 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0008, "", "", $00, $09, $00)
    createitemtemplate("S-NAV Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0008, "", "", $00, $09, $00)
    createitemtemplate("S-NAV Navigator Ultimate", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0008, "", "", $00, $09, $00)
    createitemtemplate("S-NAV 310 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0008, "", "", $00, $09, $00)
    createitemtemplate("Radio Transceiver", "radio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radioHUD.png", 1.0, "", "", $00, $09, $00)
    createitemtemplate("Radio Transceiver", "fineradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radioHUD.png", 1.0, "", "", $00, $09, $00)
    createitemtemplate("Radio Transceiver", "veryfineradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radioHUD.png", 1.0, "", "", $00, $09, $00)
    createitemtemplate("Radio Transceiver", "18vradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radioHUD.png", 1.02, "", "", $00, $09, $00)
    local0 = createitemtemplate("Cigarette", "cigarette", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Joint", "420s", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Smelly Joint", "420s", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Severed Hand", "hand", "GFX\items\severedhand.b3d", "GFX\items\INVhand.jpg", "", 0.04, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Black Severed Hand", "hand2", "GFX\items\severedhand.b3d", "GFX\items\INVhand2.jpg", "", 0.04, "GFX\items\shand2.png", "", $00, $09, $00)
    local0\Field3 = $02
    createitemtemplate("9V Battery", "bat", "GFX\items\Battery\Battery.x", "GFX\items\Battery\INVbattery9v.jpg", "", 0.008, "", "", $00, $09, $00)
    createitemtemplate("18V Battery", "18vbat", "GFX\items\Battery\Battery.x", "GFX\items\Battery\INVbattery18v.jpg", "", 0.01, "GFX\items\Battery\Battery 18V.jpg", "", $00, $09, $00)
    createitemtemplate("Strange Battery", "killbat", "GFX\items\Battery\Battery.x", "GFX\items\Battery\INVbattery22900.jpg", "", 0.01, "GFX\items\Battery\Strange Battery.jpg", "", $00, $09, $00)
    createitemtemplate("Eyedrops", "fineeyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "GFX\items\eyedrops.jpg", "", $00, $09, $00)
    createitemtemplate("Eyedrops", "supereyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "GFX\items\eyedrops.jpg", "", $00, $09, $00)
    createitemtemplate("ReVision Eyedrops", "eyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "GFX\items\eyedrops.jpg", "", $00, $09, $00)
    createitemtemplate("RedVision Eyedrops", "eyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedropsred.jpg", "", 0.0012, "GFX\items\eyedropsred.jpg", "", $00, $09, $00)
    local0 = createitemtemplate("SCP-714", "scp714", "GFX\items\scp714.b3d", "GFX\items\INV714.jpg", "", 0.3, "", "", $00, $09, $00)
    local0\Field3 = $03
    local0 = createitemtemplate("SCP-1025", "scp1025", "GFX\items\scp1025.b3d", "GFX\items\INV1025.jpg", "", 0.1, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("SCP-513", "scp513", "GFX\items\513.x", "GFX\items\INV513.jpg", "", 0.1, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Clipboard", "clipboard", "GFX\items\clipboard.b3d", "GFX\items\INVclipboard.jpg", "", 0.003, "", "GFX\items\INVclipboard2.jpg", $01, $09, $00)
    local0 = createitemtemplate("SCP-1123", "1123", "GFX\items\HGIB_Skull1.b3d", "GFX\items\inv1123.jpg", "", 0.015, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Night Vision Goggles", "supernv", "GFX\items\NVG.b3d", "GFX\items\INVsupernightvision.jpg", "", 0.02, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Night Vision Goggles", "nvgoggles", "GFX\items\NVG.b3d", "GFX\items\INVnightvision.jpg", "", 0.02, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Night Vision Goggles", "finenvgoggles", "GFX\items\NVG.b3d", "GFX\items\INVveryfinenightvision.jpg", "", 0.02, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Syringe", "syringe", "GFX\items\Syringe\syringe.b3d", "GFX\items\Syringe\inv.png", "", 0.005, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Syringe", "finesyringe", "GFX\items\Syringe\syringe.b3d", "GFX\items\Syringe\inv.png", "", 0.005, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Syringe", "veryfinesyringe", "GFX\items\Syringe\syringe.b3d", "GFX\items\Syringe\inv.png", "", 0.005, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("SCP-1499", "scp1499", "GFX\items\SCP-1499.b3d", "GFX\items\INVscp1499.jpg", "", 0.023, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("SCP-1499", "super1499", "GFX\items\SCP-1499.b3d", "GFX\items\INVscp1499.jpg", "", 0.023, "", "", $00, $09, $00)
    local0\Field3 = $02
    createitemtemplate("Emily Ross' Badge", "badge", "GFX\items\badge.x", "GFX\items\INVbadge.jpg", "GFX\items\badge1.jpg", 0.0001, "GFX\items\badge1_tex.jpg", "", $00, $09, $00)
    local0 = createitemtemplate("Lost Key", "key", "GFX\items\key.b3d", "GFX\items\INV1162_1.jpg", "", 0.001, "GFX\items\key2.png", "", $00, $0B, $00)
    local0\Field3 = $03
    local0 = createitemtemplate("Disciplinary Hearing DH-S-4137-17092", "oldpaper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\dh.s", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Coin", "coin", "GFX\items\key.b3d", "GFX\items\INVcoin.jpg", "", 0.0005, "GFX\items\coin.png", "", $00, $0B, $00)
    local0\Field3 = $03
    local0 = createitemtemplate("Movie Ticket", "ticket", "GFX\items\key.b3d", "GFX\items\INVticket.jpg", "GFX\items\ticket.png", 0.002, "GFX\items\tickettexture.png", "", $00, $0B, $00)
    local0\Field3 = $00
    createitemtemplate("Old Badge", "badge", "GFX\items\badge.x", "GFX\items\INVoldbadge.jpg", "GFX\items\badge2.png", 0.0001, "GFX\items\badge2_tex.png", "", $00, $0B, $00)
    local0 = createitemtemplate("Quarter", "25ct", "GFX\items\key.b3d", "GFX\items\INVcoin.jpg", "", 0.0005, "GFX\items\coin.png", "", $00, $0B, $00)
    local0\Field3 = $03
    local0 = createitemtemplate("Wallet", "wallet", "GFX\items\wallet.b3d", "GFX\items\INVwallet.jpg", "", 0.0005, "", "", $01, $09, $00)
    local0\Field3 = $02
    createitemtemplate("SCP-427", "scp427", "GFX\items\427.b3d", "GFX\items\INVscp427.jpg", "", 0.001, "", "", $00, $09, $00)
    local0 = createitemtemplate("Upgraded pill", "scp500death", "GFX\items\pill.b3d", "GFX\items\INVpill.jpg", "", 0.0001, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Pill", "pill", "GFX\items\pill.b3d", "GFX\items\INVpillwhite.jpg", "", 0.0001, "", "", $00, $09, $00)
    local0\Field3 = $02
    local0 = createitemtemplate("Sticky Note", "paper", "GFX\items\note.x", "GFX\items\INVnote2.jpg", "GFX\items\note682.jpg", (1.0 / 400.0), "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("The Modular Site Project", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docMSP.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Research Sector-02 Scheme", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docmap.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    local0 = createitemtemplate("Document SCP-427", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc427.jpg", 0.003, "", "", $00, $09, $00)
    local0\Field3 = $00
    createitemtemplate("USP Tactical", "usp", "GFX\items\USP_Tactical_Worldmodel.b3d", "GFX\items\INVusp.jpg", "", 0.02, "", "", $00, $09, $00)
    createitemtemplate("FN P90", "p90", "GFX\items\P90_Worldmodel.b3d", "GFX\items\INVp90.jpg", "", 0.02, "", "", $00, $09, $00)
    createitemtemplate("MP5-SD", "mp5sd", "GFX\items\mp5sd_worldmodel.b3d", "GFX\items\INVmp5.jpg", "", 0.014, "GFX\items\mp5sd_main.png", "", $00, $09, $00)
    createitemtemplate("Rocket Launcher", "rpg", "GFX\items\rpg_worldmodel.b3d", "GFX\items\INVrpg.jpg", "", 0.015, "", "", $00, $09, $00)
    createitemtemplate("Minigun", "minigun", "GFX\items\M134_Worldmodel.b3d", "GFX\items\INVm134.jpg", "", 0.014, "", "", $00, $09, $00)
    If (isahalloween() = $00) Then
        createitemtemplate("Grenade", "grenade", "GFX\items\grenadeworldmodel.b3d", "GFX\items\grenade.jpg", "", 0.014, "", "", $00, $09, $00)
    Else
        createitemtemplate("Grenade", "grenade", "GFX\items\grenadeworldmodelHw.b3d", "GFX\items\grenade.jpg", "", 0.014, "", "", $00, $09, $00)
    EndIf
    local0 = createitemtemplate("Uranium Candy", "urancandy", "GFX\items\candy.b3d", "GFX\items\candyicon.jpg", "", 0.01, "", "", $00, $09, $00)
    local0\Field3 = $02
    createitemtemplate("Cooked Chicken", "chicken", "GFX\multiplayer\game\models\c.b3d", "GFX\multiplayer\game\images\chicken.jpg", "", 0.0007, "GFX\multiplayer\game\models\chicken.jpg", "", $00, $09, $00)
    createitemtemplate("Box of ammo", "boxofammo", "GFX\items\box_ammo.b3d", "GFX\items\boxofammo.jpg", "", 0.02, "", "", $00, $09, $00)
    createitemtemplate("Micro-HID", "microhid", "GFX\items\MicroHid_Worldmodel.b3d", "GFX\items\microhid.jpg", "", 0.015, "", "", $00, $09, $00)
    createitemtemplate("Desert Eagle", "deagle", "GFX\items\deagle_worldmodel.b3d", "GFX\items\INVdeagle.jpg", "", 0.02, "", "", $00, $09, $00)
    createitemtemplate("SPAS-12", "spas12", "GFX\items\SPAS_Worldmodel.b3d", "GFX\items\INVspas.jpg", "", 0.016, "", "", $00, $09, $00)
    createitemtemplate("M4A4", "m4a4", "GFX\items\M4_Worldmodel.b3d", "GFX\items\INVm4.jpg", "", 0.02, "", "", $00, $09, $00)
    createitemtemplate("Handcuffs", "handcuffs", "GFX\items\Handcuts_Worldmodel.b3d", "GFX\items\INVhandcuts.jpg", "", 0.01, "", "", $00, $09, $00)
    createitemtemplate("SCP-035", "scp035", "GFX\items\035.b3d", "GFX\items\INV035.jpg", "", 0.018, "", "", $00, $09, $00)
    createitemtemplate("Flashbang", "grenadeflashbang", "GFX\items\flashgrenadeworldmodel.b3d", "GFX\items\INVflashgrenade.jpg", "", 0.014, "", "", $00, $09, $00)
    createitemtemplate("Smoke grenade", "grenadesmoke", "GFX\items\smokegrenadeworldmodel.b3d", "GFX\items\INVsmokegrenade.jpg", "", 0.014, "", "", $00, $09, $00)
    createitemtemplate("Combat knife", "knife", "GFX\items\knife_worldmodel.b3d", "GFX\items\INVknife.jpg", "", 0.012, "", "", $00, $09, $00)
    createitemtemplate("HK-G36", "hkg36", "GFX\items\HKG36_Worldmodel.b3d", "GFX\items\INVhkg36.jpg", "", 0.027, "", "", $00, $09, $00)
    Return $00
End Function
