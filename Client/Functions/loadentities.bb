Function loadentities%()
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local10$
    Local local11%
    Local local12$
    Local local13%
    Local local14%
    Local local15%
    networkserver\Field17 = $00
    drawloading(0.0, $00, $00, $00)
    mat_initmaterials()
    reloadholidaysentities()
    For local0 = $00 To $09 Step $01
        tempsounds[local0] = $00
    Next
    shouldforcefov = $01
    If (pausemenuimg <> $00) Then
        freeimage(pausemenuimg)
    EndIf
    If (sprinticon <> $00) Then
        freeimage(sprinticon)
    EndIf
    If (blinkmeterimg <> $00) Then
        freeimage(blinkmeterimg)
    EndIf
    If (blinkicon <> $00) Then
        freeimage(blinkicon)
    EndIf
    If (crouchicon <> $00) Then
        freeimage(crouchicon)
    EndIf
    If (handicon <> $00) Then
        freeimage(handicon)
    EndIf
    If (handicon2 <> $00) Then
        freeimage(handicon2)
    EndIf
    If (staminameterimg <> $00) Then
        freeimage(staminameterimg)
    EndIf
    If (panel294 <> $00) Then
        freeimage(panel294)
    EndIf
    pausemenuimg = loadimage_strict("GFX\menu\pausemenu.jpg")
    blinkmeterimg = loadimage_strict("GFX\blinkmeter.jpg")
    staminameterimg = loadimage_strict("GFX\staminameter.jpg")
    sprinticon = loadimage_strict("GFX\sprinticon.png")
    blinkicon = loadimage_strict("GFX\blinkicon.png")
    crouchicon = loadimage_strict("GFX\sneakicon.png")
    handicon = loadimage_strict("GFX\handsymbol.png")
    handicon2 = loadimage_strict("GFX\handsymbol2.png")
    local1 = imenuscale[$1E]
    resizeimage(sprinticon, (Float local1), (Float local1))
    resizeimage(crouchicon, (Float local1), (Float local1))
    resizeimage(blinkicon, (Float local1), (Float local1))
    local1 = imenuscale[$08]
    local2 = imenuscale[$0E]
    resizeimage(blinkmeterimg, (Float local1), (Float local2))
    resizeimage(staminameterimg, (Float local1), (Float local2))
    loadcustomprogressbars()
    g_model\Field0 = createcube($00)
    entitycolor(g_model\Field0, 255.0, 0.0, 255.0)
    entityorder(g_model\Field0, $FFFFD8F1)
    entityfx(g_model\Field0, $09)
    hideentity(g_model\Field0)
    local1 = imenuscale[$258]
    resizeimage(pausemenuimg, (Float local1), (Float local1))
    local1 = imenuscale[$40]
    resizeimage(handicon, (Float local1), (Float local1))
    resizeimage(handicon2, (Float local1), (Float local1))
    keypadhud = loadimage_strict("GFX\keypadhud.jpg")
    maskimage(keypadhud, $FF, $00, $FF)
    panel294 = loadimage_strict("GFX\294panel.jpg")
    maskimage(panel294, $FF, $00, $FF)
    camerafognear = 0.5
    camerafogfar = (10.0 - (Float (iscoopmode() Shl $02)))
    storedcamerafogfar = camerafogfar
    ambientlightroomtex = createtexture($02, $02, $101, $01)
    textureblend(ambientlightroomtex, $05)
    setbuffer(texturebuffer(ambientlightroomtex, $00))
    clscolor($00, $00, $00, $FF)
    cls()
    setbuffer(backbuffer())
    ambientlightroomval = $00
    soundemitter = createpivot($00)
    camera = createcamera($00)
    cameraclsmode(camera, $01, $01)
    cameraviewport(camera, $00, $00, graphicwidth, graphicheight)
    camerarange(camera, 0.02, camerafogfar)
    camerafogmode(camera, $01)
    camerafogrange(camera, camerafognear, camerafogfar)
    ambientlight(120.0, 120.0, 120.0)
    cameraprojmode(camera, $00)
    initgamma()
    landscapecamera = createcamera($00)
    positionentity(landscapecamera, 900.0, 1.0, 900.0, $00)
    cameraviewport(landscapecamera, $00, $00, graphicwidth, graphicheight)
    landscapeobj = loadmesh_strict("GFX\multiplayer\game\models\Landscape_SURFACE.b3d", $00)
    entityfx(landscapeobj, $01)
    positionentity(landscapeobj, 900.0, 1.0, 900.0, $00)
    local3 = "GFX\map\sky\Singleplayer\"
    If (networkserver\Field12 = $01) Then
        local3 = "GFX\map\sky\Breach\"
    EndIf
    sky_createsky(landscapeobj, $00, local3)
    camerarange(landscapecamera, 0.01, sky_planedist[$00])
    camerafogmode(landscapecamera, $01)
    camerafogcolor(landscapecamera, 175.0, 195.0, 220.0)
    cameraprojmode(landscapecamera, $00)
    camerafogrange(landscapecamera, 0.0, sky_fogdist[$00])
    screentexs[$00] = createtexture(getcameraquality(camquality), getcameraquality(camquality), $01, $01)
    screentexs[$01] = createtexture(getcameraquality(camquality), getcameraquality(camquality), $01, $01)
    createblurimage()
    cameraprojmode(ark_blur_cam, $00)
    local4 = (((Float graphicwidth) / (Float graphicheight)) / ((Float win\Field2) / (Float win\Field3)))
    aspectratioratio = local4
    fogtexture = loadtexture_strict("GFX\fog.jpg", $01)
    fognvtexture = loadtexture_strict("GFX\fogNV.jpg", $01)
    fog = createsprite(ark_blur_cam)
    scalesprite(fog, 1.0, local4)
    entitytexture(fog, fogtexture, $00, $00)
    entityblend(fog, $02)
    moveentity(fog, 0.0, 0.0, 1.0)
    entityorder(fog, $FFFFFC18)
    If (overlaysenabled <> 0) Then
        hideentity(fog)
    EndIf
    gasmasktexture = loadtexture_strict("GFX\GasmaskOverlay.jpg", $01)
    gasmaskoverlay = createsprite(ark_blur_cam)
    scalesprite(gasmaskoverlay, 1.0, local4)
    entitytexture(gasmaskoverlay, gasmasktexture, $00, $00)
    entityblend(gasmaskoverlay, $02)
    entityfx(gasmaskoverlay, $01)
    entityorder(gasmaskoverlay, $FFFFFC15)
    moveentity(gasmaskoverlay, 0.0, 0.0, 1.0)
    hideentity(gasmaskoverlay)
    infecttexture = loadtexture_strict("GFX\InfectOverlay.jpg", $01)
    infectoverlay = createsprite(ark_blur_cam)
    scalesprite(infectoverlay, 1.0, local4)
    entitytexture(infectoverlay, infecttexture, $00, $00)
    entityblend(infectoverlay, $03)
    entityfx(infectoverlay, $01)
    entityorder(infectoverlay, $FFFFFC15)
    moveentity(infectoverlay, 0.0, 0.0, 1.0)
    hideentity(infectoverlay)
    nvtexture = loadtexture_strict("GFX\NightVisionOverlay.jpg", $01)
    nvoverlay = createsprite(ark_blur_cam)
    scalesprite(nvoverlay, 1.0, local4)
    entitytexture(nvoverlay, nvtexture, $00, $00)
    entityblend(nvoverlay, $02)
    entityfx(nvoverlay, $01)
    entityorder(nvoverlay, $FFFFFC15)
    moveentity(nvoverlay, 0.0, 0.0, 1.0)
    hideentity(nvoverlay)
    nvblink = createsprite(ark_blur_cam)
    scalesprite(nvblink, 1.0, local4)
    entitycolor(nvblink, 0.0, 0.0, 0.0)
    entityfx(nvblink, $01)
    entityorder(nvblink, $FFFFFC13)
    moveentity(nvblink, 0.0, 0.0, 1.0)
    hideentity(nvblink)
    darktexture = createtexture(smallest_power_two_half, smallest_power_two_half, $03, $01)
    setbuffer(texturebuffer(darktexture, $00))
    cls()
    setbuffer(backbuffer())
    dark = createsprite(ark_blur_cam)
    scalesprite(dark, 1.0, local4)
    entitytexture(dark, darktexture, $00, $00)
    entityblend(dark, $01)
    entityorder(dark, $FFFFFC16)
    moveentity(dark, 0.0, 0.0, 1.0)
    entityalpha(dark, 0.0)
    lighttexture = createtexture(smallest_power_two_half, smallest_power_two_half, $03, $01)
    setbuffer(texturebuffer(lighttexture, $00))
    clscolor($FF, $FF, $FF, $FF)
    cls()
    clscolor($00, $00, $00, $FF)
    setbuffer(backbuffer())
    light = createsprite(ark_blur_cam)
    scalesprite(light, 1.0, local4)
    entitytexture(light, lighttexture, $00, $00)
    entityblend(light, $01)
    entityorder(light, $FFFFFC16)
    moveentity(light, 0.0, 0.0, 1.0)
    hideentity(light)
    initguns()
    teslatexture = loadtexture_strict("GFX\map\tesla.jpg", $03)
    lightspritetex($00) = loadtexture_strict("GFX\light1.jpg", $03)
    lightspritetex($01) = loadtexture_strict("GFX\light2.jpg", $03)
    lightspritetex($02) = loadtexture_strict("GFX\lightsprite.jpg", $03)
    drawloading(60.0, $00, $00, $00)
    elevatordoorobj = loadmesh_strict("GFX\map\elevatordoor.b3d", $00)
    scaleentity(elevatordoorobj, (0.796875 / meshwidth(elevatordoorobj)), (1.21875 / meshheight(elevatordoorobj)), ((1.0 / 16.0) / meshdepth(elevatordoorobj)), $00)
    hideentity(elevatordoorobj)
    doorobj = loadmesh_strict("GFX\map\door01.x", $00)
    scaleentity(doorobj, (0.796875 / meshwidth(doorobj)), (1.21875 / meshheight(doorobj)), ((1.0 / 16.0) / meshdepth(doorobj)), $00)
    hideentity(doorobj)
    doorframeobj = loadmesh_strict("GFX\map\doorframe.x", $00)
    scaleentity(doorframeobj, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    hideentity(doorframeobj)
    heavydoorobj($00) = loadmesh_strict("GFX\map\heavydoor1.x", $00)
    hideentity(heavydoorobj($00))
    heavydoorobj($01) = loadmesh_strict("GFX\map\heavydoor2.x", $00)
    hideentity(heavydoorobj($01))
    For local0 = $00 To $01 Step $01
        scaleentity(heavydoorobj(local0), (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    Next
    doorcoll = loadmesh_strict("GFX\map\doorcoll.x", $00)
    scaleentity(doorcoll, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    hideentity(doorcoll)
    buttonobj = loadmesh_strict("GFX\map\Button.x", $00)
    scaleentity(buttonobj, 0.03, 0.03, 0.03, $00)
    hideentity(buttonobj)
    applyreflection(buttonobj)
    buttonkeyobj = loadmesh_strict("GFX\map\ButtonKeycard.x", $00)
    scaleentity(buttonkeyobj, 0.03, 0.03, 0.03, $00)
    hideentity(buttonkeyobj)
    applyreflection(buttonkeyobj)
    buttoncodeobj = loadmesh_strict("GFX\map\ButtonCode.x", $00)
    scaleentity(buttoncodeobj, 0.03, 0.03, 0.03, $00)
    hideentity(buttoncodeobj)
    applyreflection(buttoncodeobj)
    buttonscannerobj = loadmesh_strict("GFX\map\ButtonScanner.x", $00)
    scaleentity(buttonscannerobj, 0.03, 0.03, 0.03, $00)
    hideentity(buttonscannerobj)
    applyreflection(buttonscannerobj)
    bigdoorobj($00) = loadmesh_strict("GFX\map\ContDoorLeft.x", $00)
    hideentity(bigdoorobj($00))
    bigdoorobj($01) = loadmesh_strict("GFX\map\ContDoorRight.x", $00)
    hideentity(bigdoorobj($01))
    local5 = (1.0 / 4.654545)
    For local0 = $00 To $01 Step $01
        scaleentity(bigdoorobj(local0), local5, local5, local5, $00)
    Next
    leverbaseobj = loadmesh_strict("GFX\map\leverbase.x", $00)
    hideentity(leverbaseobj)
    applyreflection(leverbaseobj)
    leverobj = loadmesh_strict("GFX\map\leverhandle.x", $00)
    hideentity(leverobj)
    drawloading(70.0, $00, $00, $00)
    For local0 = $00 To $05 Step $01
        gorepics(local0) = loadtexture_strict((("GFX\895pics\pic" + (Str (local0 + $01))) + ".jpg"), $01)
    Next
    oldaipics($00) = loadtexture_strict("GFX\AIface.jpg", $01)
    oldaipics($01) = loadtexture_strict("GFX\AIface2.jpg", $01)
    For local0 = $00 To $06 Step $01
        decaltextures[local0] = loadtexture_strict((("GFX\decal" + (Str (local0 + $01))) + ".png"), $03)
    Next
    decaltextures[$07] = loadtexture_strict("GFX\items\INVpaperstrips.jpg", $03)
    For local0 = $08 To $0C Step $01
        decaltextures[local0] = loadtexture_strict((("GFX\decalpd" + (Str (local0 - $07))) + ".jpg"), $03)
    Next
    For local0 = $0D To $0E Step $01
        decaltextures[local0] = loadtexture_strict((("GFX\bullethole" + (Str (local0 - $0C))) + ".jpg"), $03)
    Next
    For local0 = $0F To $10 Step $01
        decaltextures[local0] = loadtexture_strict((("GFX\blooddrop" + (Str (local0 - $0E))) + ".png"), $03)
    Next
    drawloading(75.0, $00, $00, $00)
    decaltextures[$11] = loadtexture_strict("GFX\decal8.png", $03)
    decaltextures[$12] = loadtexture_strict("GFX\decalpd6.dc", $03)
    decaltextures[$14] = loadtexture_strict("GFX\decal427.png", $03)
    particletextures[$00] = loadtexture_strict("GFX\smoke.png", $0B)
    particletextures[$01] = loadtexture_strict("GFX\flash.jpg", $0B)
    particletextures[$02] = loadtexture_strict("GFX\dust.jpg", $0B)
    particletextures[$03] = loadtexture_strict("GFX\npcs\hg.pt", $03)
    particletextures[$04] = loadtexture_strict("GFX\map\sun.jpg", $0B)
    particletextures[$05] = loadtexture_strict("GFX\bloodsprite.png", $0B)
    particletextures[$06] = loadtexture_strict("GFX\smoke2.png", $0A)
    particletextures[$07] = loadtexture_strict("GFX\spark.jpg", $0B)
    particletextures[$08] = loadtexture_strict("GFX\particle.png", $0B)
    particletextures[$09] = loadtexture_strict("GFX\snow.jpg", $0B)
    particletextures[$0B] = loadtexture_strict("GFX\leafs.png", $07)
    entitytexture(g_model\Field2, particletextures[$01], $00, $00)
    monitor = loadmesh_strict("GFX\map\monitor.b3d", $00)
    hideentity(monitor)
    monitortexture = loadtexture_strict("GFX\monitortexture.jpg", $01)
    cambaseobj = loadmesh_strict("GFX\map\cambase.x", $00)
    hideentity(cambaseobj)
    camobj = loadmesh_strict("GFX\map\CamHead.b3d", $00)
    hideentity(camobj)
    scaleentity(cambaseobj, 0.0015, 0.0015, 0.0015, $00)
    scaleentity(camobj, 0.01, 0.01, 0.01, $00)
    monitor2 = loadmesh_strict("GFX\map\monitor_checkpoint.b3d", $00)
    hideentity(monitor2)
    monitor3 = loadmesh_strict("GFX\map\monitor_checkpoint.b3d", $00)
    hideentity(monitor3)
    monitortexture2 = loadtexture_strict("GFX\map\LockdownScreen2.jpg", $01)
    monitortexture3 = loadtexture_strict("GFX\map\LockdownScreen.jpg", $01)
    monitortexture4 = loadtexture_strict("GFX\map\LockdownScreen3.jpg", $01)
    monitortextureoff = createtexture($01, $01, $00, $01)
    setbuffer(texturebuffer(monitortextureoff, $00))
    clscolor($00, $00, $00, $FF)
    cls()
    setbuffer(backbuffer())
    drawloading(85.0, $00, $00, $00)
    For local0 = $02 To countsurfaces(monitor2) Step $01
        local6 = getsurface(monitor2, local0)
        local7 = getsurfacebrush(local6)
        If (local7 <> $00) Then
            local8 = getbrushtexture(local7, $00)
            If (local8 <> $00) Then
                local9 = strippath(texturename(local8))
                If (lower(local9) <> "monitortexture.jpg") Then
                    brushtexture(local7, monitortextureoff, $00, $00)
                    paintsurface(local6, local7)
                EndIf
                If (local9 <> "") Then
                    freetexture(local8)
                EndIf
            EndIf
            freebrush(local7)
        EndIf
    Next
    For local0 = $02 To countsurfaces(monitor3) Step $01
        local6 = getsurface(monitor3, local0)
        local7 = getsurfacebrush(local6)
        If (local7 <> $00) Then
            local8 = getbrushtexture(local7, $00)
            If (local8 <> $00) Then
                local9 = strippath(texturename(local8))
                If (lower(local9) <> "monitortexture.jpg") Then
                    brushtexture(local7, monitortextureoff, $00, $00)
                    paintsurface(local6, local7)
                EndIf
                If (local9 <> "") Then
                    freetexture(local8)
                EndIf
            EndIf
            freebrush(local7)
        EndIf
    Next
    usertrackmusicamount = $00
    If (enableusertracks <> 0) Then
        local10 = "SFX\Radio\UserTracks\"
        If (filetype(local10) <> $02) Then
            createdir(local10)
        EndIf
        local11 = readdir("SFX\Radio\UserTracks\")
        Repeat
            local12 = nextfile(local11)
            If (local12 = "") Then
                Exit
            EndIf
            If (filetype(("SFX\Radio\UserTracks\" + local12)) = $01) Then
                local13 = loadsound(("SFX\Radio\UserTracks\" + local12))
                If (local13 <> $00) Then
                    usertrackname(usertrackmusicamount) = local12
                    usertrackmusicamount = (usertrackmusicamount + $01)
                EndIf
                freesound(local13)
            EndIf
        Forever
        closedir(local11)
    EndIf
    inititemtemplates()
    setchunkdatavalues()
    For local0 = $01 To $0B Step $01
        dtextures[local0] = copyentity(g_model\Field4, $00)
        hideentity(dtextures[local0])
    Next
    local14 = loadtexture_strict("GFX\npcs\gonzales.jpg", $01)
    entitytexture(dtextures[$01], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\corpse.jpg", $01)
    entitytexture(dtextures[$02], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\scientist.jpg", $01)
    entitytexture(dtextures[$03], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\scientist2.jpg", $01)
    entitytexture(dtextures[$04], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\janitor.jpg", $01)
    entitytexture(dtextures[$05], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\106victim.jpg", $01)
    entitytexture(dtextures[$06], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\classd2.jpg", $01)
    entitytexture(dtextures[$07], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\035victim.jpg", $01)
    entitytexture(dtextures[$08], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\body2.jpg", $01)
    entitytexture(dtextures[$09], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\classd3.jpg", $01)
    entitytexture(dtextures[$0A], local14, $00, $00)
    freetexture(local14)
    local14 = loadtexture_strict("GFX\npcs\body1.jpg", $01)
    entitytexture(dtextures[$0B], local14, $00, $00)
    freetexture(local14)
    loadmaterials("DATA\materials.ini")
    objtunnel($00) = loadrmesh("GFX\map\mt1.rmesh", Null)
    hideentity(objtunnel($00))
    objtunnel($01) = loadrmesh("GFX\map\mt2.rmesh", Null)
    hideentity(objtunnel($01))
    objtunnel($02) = loadrmesh("GFX\map\mt2c.rmesh", Null)
    hideentity(objtunnel($02))
    objtunnel($03) = loadrmesh("GFX\map\mt3.rmesh", Null)
    hideentity(objtunnel($03))
    objtunnel($04) = loadrmesh("GFX\map\mt4.rmesh", Null)
    hideentity(objtunnel($04))
    objtunnel($05) = loadrmesh("GFX\map\mt_elevator.rmesh", Null)
    hideentity(objtunnel($05))
    objtunnel($06) = loadrmesh("GFX\map\mt_generator.rmesh", Null)
    hideentity(objtunnel($06))
    initparticles(camera)
    particleeffect[$00] = createtemplate()
    settemplateemitterblend(particleeffect[$00], $03)
    settemplateinterval(particleeffect[$00], $01)
    settemplateparticlesperinterval(particleeffect[$00], $04)
    settemplateemitterlifetime(particleeffect[$00], $01)
    settemplateparticlelifetime(particleeffect[$00], $05, $0A)
    settemplatetexture(particleeffect[$00], "GFX\Spark.png", $0B, $03)
    settemplateoffset(particleeffect[$00], -0.01, 0.01, -0.01, 0.01, -0.01, 0.01)
    settemplatevelocity(particleeffect[$00], -0.08, 0.08, -0.08, 0.08, -0.08, 0.08)
    settemplatealigntofall(particleeffect[$00], $01, $2D)
    settemplategravity(particleeffect[$00], 0.001)
    settemplatealphavel(particleeffect[$00], $01)
    settemplatesize(particleeffect[$00], 0.015, 0.03, 0.7, 1.0)
    settemplatecolors(particleeffect[$00], $FFFF00, $FFFF65)
    settemplatefloor(particleeffect[$00], 0.0, 0.5)
    particleeffect[$01] = createtemplate()
    settemplateemitterblend(particleeffect[$01], $01)
    settemplateinterval(particleeffect[$01], $01)
    settemplateemitterlifetime(particleeffect[$01], $03)
    settemplateparticlelifetime(particleeffect[$01], $1E, $2D)
    settemplatetexture(particleeffect[$01], "GFX\smoke2.png", $02, $01)
    settemplateoffset(particleeffect[$01], 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    settemplatevelocity(particleeffect[$01], 0.0, 0.0, 0.02, 0.025, 0.0, 0.0)
    settemplatealphavel(particleeffect[$01], $01)
    settemplatesize(particleeffect[$01], 0.4, 0.4, 0.5, 1.5)
    settemplatesizevel(particleeffect[$01], 0.01, 1.01)
    particleeffect[$02] = createtemplate()
    settemplateemitterblend(particleeffect[$02], $01)
    settemplateinterval(particleeffect[$02], $01)
    settemplateemitterlifetime(particleeffect[$02], $03)
    settemplateparticlelifetime(particleeffect[$02], $1E, $2D)
    settemplatetexture(particleeffect[$02], "GFX\smoke.png", $02, $01)
    settemplateoffset(particleeffect[$02], -0.1, 0.1, -0.1, 0.1, -0.1, 0.1)
    settemplatevelocity(particleeffect[$02], -0.005, 0.005, 0.0, -0.03, -0.005, 0.005)
    settemplatealphavel(particleeffect[$02], $01)
    settemplatesize(particleeffect[$02], 0.4, 0.4, 0.5, 1.5)
    settemplatesizevel(particleeffect[$02], 0.01, 1.01)
    settemplategravity(particleeffect[$02], 0.005)
    particleeffect[$03] = createtemplate()
    settemplateemitterblend(particleeffect[$03], $03)
    settemplateinterval(particleeffect[$03], $01)
    settemplateparticlesperinterval(particleeffect[$03], $06)
    settemplateemitterlifetime(particleeffect[$03], $06)
    settemplateparticlelifetime(particleeffect[$03], $14, $1E)
    settemplatetexture(particleeffect[$03], "GFX\flash.jpg", $03, $03)
    settemplateoffset(particleeffect[$03], -0.1, 0.1, 0.15, 0.15, -0.1, 0.1)
    settemplatevelocity(particleeffect[$03], -0.0375, 0.0375, -0.0375, 0.0375, -0.0375, 0.0375)
    settemplatealigntofall(particleeffect[$03], $01, $FFFFFFD3)
    settemplategravity(particleeffect[$03], 0.001)
    settemplatealphavel(particleeffect[$03], $01)
    settemplatesize(particleeffect[$03], 0.125, 0.125, 1.4, 2.0)
    settemplatefloor(particleeffect[$03], 0.0, 0.5)
    particleeffect[$04] = createtemplate()
    settemplateemitterblend(particleeffect[$04], $01)
    settemplateinterval(particleeffect[$04], $07)
    settemplateparticlesperinterval(particleeffect[$04], $05)
    settemplateemitterlifetime(particleeffect[$04], $14)
    settemplateparticlelifetime(particleeffect[$04], $C8, $DC)
    settemplatetexture(particleeffect[$04], "GFX\smoke.png", $02, $01)
    settemplateoffset(particleeffect[$04], -0.1, 0.1, 0.15, 0.15, -0.1, 0.1)
    settemplatevelocity(particleeffect[$04], -0.0175, 0.0175, 0.001, 0.001, -0.0175, 0.0075)
    settemplategravity(particleeffect[$04], 0.0)
    settemplatealphavel(particleeffect[$04], $01)
    settemplatesize(particleeffect[$04], 0.9, 0.7, 1.0, 1.0)
    particleeffect[$05] = createtemplate()
    settemplateemitterblend(particleeffect[$05], $01)
    settemplateinterval(particleeffect[$05], $14)
    settemplateparticlesperinterval(particleeffect[$05], $08)
    settemplateemitterlifetime(particleeffect[$05], $7D0)
    settemplateparticlelifetime(particleeffect[$05], $C8, $1C2)
    settemplatetexture(particleeffect[$05], "GFX\smoke2.png", $02, $01)
    settemplateoffset(particleeffect[$05], -2.0, 2.0, 0.01, 0.1, -2.0, 2.0)
    settemplatevelocity(particleeffect[$05], -0.02, 0.02, 0.02, 0.04, -0.02, 0.02)
    settemplategravity(particleeffect[$05], 0.0)
    settemplatealphavel(particleeffect[$05], $01)
    settemplatesize(particleeffect[$05], 2.0, 2.0, 1.0, 1.0)
    particleeffect[$06] = createtemplate()
    settemplateemitterblend(particleeffect[$06], $01)
    settemplateinterval(particleeffect[$06], $07)
    settemplateparticlesperinterval(particleeffect[$06], $05)
    settemplateemitterlifetime(particleeffect[$06], $14)
    settemplateparticlelifetime(particleeffect[$06], $64, $78)
    settemplatetexture(particleeffect[$06], "GFX\smoke.png", $02, $01)
    settemplateoffset(particleeffect[$06], -0.1, 0.1, 0.15, 0.15, -0.1, 0.1)
    settemplatevelocity(particleeffect[$06], -0.00875, 0.00875, 0.001, 0.001, -0.00875, 0.00375)
    settemplategravity(particleeffect[$06], 0.0)
    settemplatealphavel(particleeffect[$06], $01)
    settemplatesize(particleeffect[$06], 0.225, 0.175, 1.0, 1.0)
    local15 = createtemplate()
    settemplateemitterblend(local15, $01)
    settemplateinterval(local15, $01)
    settemplateemitterlifetime(local15, $03)
    settemplateparticlelifetime(local15, $1E, $2D)
    settemplatetexture(local15, "GFX\smoke2.png", $02, $01)
    settemplateoffset(local15, -0.1, 0.1, -0.1, 0.1, -0.1, 0.1)
    settemplatevelocity(local15, -0.005, 0.005, 0.0, -0.03, -0.005, 0.005)
    settemplatealphavel(local15, $01)
    settemplatesize(local15, 0.4, 0.4, 0.5, 1.5)
    settemplatesizevel(local15, 0.01, 1.01)
    settemplategravity(particleeffect[$02], 0.005)
    settemplatesubtemplate(particleeffect[$02], local15, $00)
    room2slcam = createcamera($00)
    cameraviewport(room2slcam, $00, $00, $80, $80)
    camerarange(room2slcam, 0.05, 6.0)
    camerazoom(room2slcam, 0.8)
    hideentity(room2slcam)
    networkserver\Field17 = $01
    drawloading(99.0, $00, $00, $00)
    Return $00
End Function
