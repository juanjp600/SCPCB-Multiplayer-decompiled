Function loadentities%()
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4$
    Local local5#
    Local local6$
    Local local7%
    catcherrors("LoadEntities()")
    deinitmainmenuassets()
    renderloading($00, getlocalstring("loading", "data"))
    loaddata()
    initsubtitlesassets()
    renderloading($03, getlocalstring("loading", "player"))
    soundemitter = createpivot($00)
    me\Field60 = createpivot($00)
    entityradius(me\Field60, 0.15, 0.3)
    entitypickmode(me\Field60, $01, $01)
    entitytype(me\Field60, $02, $00)
    me\Field62 = me\Field60
    me\Field61 = createpivot($00)
    entityradius(me\Field61, 0.15, 0.0)
    entitytype(me\Field61, $02, $00)
    camera = createcamera($00)
    cameraviewport(camera, $00, $00, opt\Field46, opt\Field47)
    camerafogmode(camera, $01)
    camerafogrange(camera, 0.1, fog\Field0)
    camerafogcolor(camera, 30.0, 30.0, 30.0)
    camerarange(camera, 0.01, fog\Field0)
    cameraclscolor(camera, 30.0, 30.0, 30.0)
    ambientlight(30.0, 30.0, 30.0)
    particlecam = camera
    particlepiv = createpivot($00)
    renderloading($05, getlocalstring("loading", "icons"))
    t\Field0[$00] = scaleimageex(loadimage_strict("GFX\HUD\walk_icon.png"), menuscale, menuscale, $01)
    t\Field0[$01] = scaleimageex(loadimage_strict("GFX\HUD\sprint_icon.png"), menuscale, menuscale, $01)
    t\Field0[$02] = scaleimageex(loadimage_strict("GFX\HUD\crouch_icon.png"), menuscale, menuscale, $01)
    For local0 = $03 To $04 Step $01
        t\Field0[local0] = loadimage_strict((("GFX\HUD\blink_icon(" + (Str (local0 - $02))) + ").png"))
        t\Field0[local0] = scaleimageex(t\Field0[local0], menuscale, menuscale, $01)
    Next
    For local0 = $05 To $06 Step $01
        t\Field0[local0] = scaleimageex(loadimage_strict((("GFX\HUD\hand_symbol(" + (Str (local0 - $04))) + ").png")), menuscale, menuscale, $01)
    Next
    t\Field0[$07] = scaleimageex(loadimage_strict("GFX\HUD\shield_icon.png"), menuscale, menuscale, $01)
    t\Field0[$08] = scaleimageex(loadimage_strict("GFX\HUD\scp_268_icon.png"), menuscale, menuscale, $01)
    t\Field0[$09] = scaleimageex(loadimage_strict("GFX\Menu\QuickLoading.png"), menuscale, menuscale, $01)
    For local0 = $00 To $03 Step $01
        t\Field0[(local0 + $0A)] = scaleimageex(loadimage_strict("GFX\HUD\arrow_symbol.png"), menuscale, menuscale, $01)
        rotateimage(t\Field0[(local0 + $0A)], ((Float local0) * 90.0))
        handleimage(t\Field0[(local0 + $0A)], $00, $00)
    Next
    t\Field0[$0E] = scaleimageex(loadimage_strict("GFX\HUD\voice.png"), menuscale, menuscale, $01)
    t\Field0[$0F] = scaleimageex(loadimage_strict("GFX\HUD\voice_active.png"), menuscale, menuscale, $01)
    t\Field0[$10] = scaleimageex(loadimage_strict("GFX\HUD\voice_disabled.png"), menuscale, menuscale, $01)
    t\Field1[$00] = scaleimageex(loadimage_strict("GFX\Menu\pause_menu.png"), menuscale, menuscale, $01)
    t\Field1[$01] = scaleimageex(loadimage_strict("GFX\HUD\blink_meter(2).png"), menuscale, menuscale, $01)
    For local0 = $02 To $03 Step $01
        t\Field1[local0] = scaleimageex(loadimage_strict((("GFX\HUD\stamina_meter(" + (Str (local0 - $01))) + ").png")), menuscale, menuscale, $01)
    Next
    t\Field1[$04] = scaleimageex(loadimage_strict("GFX\HUD\keypad_HUD.png"), menuscale, menuscale, $01)
    t\Field1[$05] = scaleimageex(loadimage_strict("GFX\Overlays\scp_294_overlay.png"), menuscale, menuscale, $01)
    t\Field1[$06] = scaleimageex(loadanimimage_strict("GFX\HUD\NVG_batteries.png", $40, $40, $00, $03), menuscale, menuscale, $03)
    maskimage(t\Field1[$06], $FF, $00, $FF)
    t\Field1[$07] = createimage(opt\Field46, opt\Field47, $01)
    renderloading($0A, getlocalstring("loading", "textures"))
    loadmissingtexture()
    ambientlightroomtex = createtextureusingcachesystem($02, $02, ((opt\Field3 Shl $08) + $01), $01, $01)
    textureblend(ambientlightroomtex, $02)
    setbuffer(texturebuffer(ambientlightroomtex, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    createblurimage()
    local5 = ((graphicheightfloat / graphicwidthfloat) + 0.001)
    t\Field2[$00] = loadtexture_strict("GFX\Overlays\vignette_overlay.png", $01, $01, $00)
    t\Field3[$00] = createsprite(arkblurcam)
    scalesprite(t\Field3[$00], 1.001, local5)
    entitytexture(t\Field3[$00], t\Field2[$00], $00, $00)
    entityblend(t\Field3[$00], $02)
    entityorder(t\Field3[$00], $FFFFFC18)
    moveentity(t\Field3[$00], 0.0, 0.0, 1.0)
    local1 = loadtexture_strict("GFX\Overlays\gas_mask_overlay.png", $01, $00, $00)
    t\Field3[$01] = createsprite(arkblurcam)
    scalesprite(t\Field3[$01], 1.001, local5)
    entitytexture(t\Field3[$01], local1, $00, $00)
    entityblend(t\Field3[$01], $02)
    entityfx(t\Field3[$01], $01)
    entityorder(t\Field3[$01], $FFFFFC15)
    moveentity(t\Field3[$01], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    local1 = loadtexture_strict("GFX\Overlays\hazmat_suit_overlay.png", $01, $00, $00)
    t\Field3[$02] = createsprite(arkblurcam)
    scalesprite(t\Field3[$02], 1.001, local5)
    entitytexture(t\Field3[$02], local1, $00, $00)
    entityblend(t\Field3[$02], $02)
    entityfx(t\Field3[$02], $01)
    entityorder(t\Field3[$02], $FFFFFC15)
    moveentity(t\Field3[$02], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    local1 = loadtexture_strict("GFX\Overlays\scp_008_overlay.png", $01, $00, $00)
    t\Field3[$03] = createsprite(arkblurcam)
    scalesprite(t\Field3[$03], 1.001, local5)
    entitytexture(t\Field3[$03], local1, $00, $00)
    entityblend(t\Field3[$03], $03)
    entityfx(t\Field3[$03], $01)
    entityorder(t\Field3[$03], $FFFFFC15)
    entityalpha(t\Field3[$03], 0.0)
    moveentity(t\Field3[$03], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    t\Field2[$01] = loadtexture_strict("GFX\Overlays\night_vision_goggles_overlay.png", $01, $01, $00)
    t\Field3[$04] = createsprite(arkblurcam)
    scalesprite(t\Field3[$04], 1.001, local5)
    entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
    entityblend(t\Field3[$04], $02)
    entityfx(t\Field3[$04], $01)
    entityorder(t\Field3[$04], $FFFFFC15)
    moveentity(t\Field3[$04], 0.0, 0.0, 1.0)
    t\Field2[$02] = createtextureusingcachesystem((Int smallest_power_two_half), (Int smallest_power_two_half), ((opt\Field3 Shl $08) + $03), $01, $01)
    setbuffer(texturebuffer(t\Field2[$02], $00))
    cls()
    setbuffer(backbuffer())
    t\Field3[$05] = createsprite(arkblurcam)
    scalesprite(t\Field3[$05], 1.001, local5)
    entitytexture(t\Field3[$05], t\Field2[$02], $00, $00)
    entityblend(t\Field3[$05], $01)
    entityorder(t\Field3[$05], $FFFFFC16)
    moveentity(t\Field3[$05], 0.0, 0.0, 1.0)
    entityalpha(t\Field3[$05], 0.0)
    local1 = createtextureusingcachesystem((Int smallest_power_two_half), (Int smallest_power_two_half), ((opt\Field3 Shl $08) + $03), $01, $00)
    setbuffer(texturebuffer(local1, $00))
    clscolor($FF, $FF, $FF)
    cls()
    clscolor($00, $00, $00)
    setbuffer(backbuffer())
    t\Field3[$06] = createsprite(arkblurcam)
    scalesprite(t\Field3[$06], 1.001, local5)
    entitytexture(t\Field3[$06], local1, $00, $00)
    entityblend(t\Field3[$06], $01)
    entityorder(t\Field3[$06], $FFFFFC16)
    moveentity(t\Field3[$06], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    local1 = loadtexture_strict("GFX\Overlays\scp_409_overlay.png", $01, $00, $00)
    t\Field3[$07] = createsprite(arkblurcam)
    scalesprite(t\Field3[$07], 1.001, local5)
    entitytexture(t\Field3[$07], local1, $00, $00)
    entityblend(t\Field3[$07], $03)
    entityfx(t\Field3[$07], $01)
    entityorder(t\Field3[$07], $FFFFFC15)
    entityalpha(t\Field3[$07], 0.0)
    moveentity(t\Field3[$07], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    local1 = loadtexture_strict("GFX\Overlays\helmet_overlay.png", $01, $00, $00)
    t\Field3[$08] = createsprite(arkblurcam)
    scalesprite(t\Field3[$08], 1.001, local5)
    entitytexture(t\Field3[$08], local1, $00, $00)
    entityblend(t\Field3[$08], $02)
    entityfx(t\Field3[$08], $01)
    entityorder(t\Field3[$08], $FFFFFC15)
    moveentity(t\Field3[$08], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    local1 = loadtexture_strict("GFX\Overlays\fog_gas_mask_overlay.png", $01, $00, $00)
    t\Field3[$09] = createsprite(arkblurcam)
    scalesprite(t\Field3[$09], 1.001, local5)
    entitytexture(t\Field3[$09], local1, $00, $00)
    entityblend(t\Field3[$09], $03)
    entityfx(t\Field3[$09], $01)
    entityorder(t\Field3[$09], $FFFFFC16)
    entityalpha(t\Field3[$09], 0.0)
    moveentity(t\Field3[$09], 0.0, 0.0, 1.0)
    deletesingletextureentryfromcache(local1, $00)
    local1 = $00
    For local0 = $01 To $09 Step $01
        hideentity(t\Field3[local0])
    Next
    t\Field2[$03] = loadtexture_strict("GFX\Overlays\tesla_overlay.png", $03, $01, $00)
    loaddecals()
    loadparticles()
    loadmaterials("Data\materials.ini")
    renderloading($0D, getlocalstring("loading", "models"))
    loaddoors()
    loadnpcs()
    loadlevers()
    loadmonitors()
    loadsecuritycams()
    loadmisc()
    loaditems()
    renderloading($0F, getlocalstring("loading", "chunks"))
    setchunkdatavalues()
    renderloading($14, getlocalstring("loading", "tracks"))
    usertrackmusicamount = $00
    If (opt\Field24 > $00) Then
        local6 = "SFX\Radio\UserTracks\"
        If (filetype(local6) <> $02) Then
            createdir(local6)
        EndIf
        local7 = readdir(local6)
        Repeat
            local4 = nextfile(local7)
            If (local4 = "") Then
                Exit
            EndIf
            If (filetype((local6 + local4)) = $01) Then
                local3 = loadsound((local6 + local4))
                If (local3 <> $00) Then
                    usertrackname[usertrackmusicamount] = local4
                    usertrackmusicamount = (usertrackmusicamount + $01)
                EndIf
                freesound(local3)
                local3 = $00
            EndIf
        Forever
        closedir(local7)
    EndIf
    renderloading($19, getlocalstring("loading", "graphic"))
    antialias(opt\Field1)
    texturelodbias(opt\Field9)
    textureanisotropic(opt\Field13)
    renderloading($1E, getlocalstring("loading", "console"))
    consoler = $00
    consoleg = $FF
    consoleb = $FF
    createconsolemsg("Console commands: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - help [page]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - godmode [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noclip [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - infinitestamina [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noblink [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - notarget [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noclipspeed [x] (default = 2.0)", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - wireframe [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - debughud [category]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - camerafog [x]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - spawnitem [item name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - 106retreat", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - disable173 / enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - disable106 / enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - spawn [NPC type]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    mp_initializerenderer()
    catcherrors("Uncaught: LoadEntities()")
    Return $00
End Function
