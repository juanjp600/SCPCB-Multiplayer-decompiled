Function loadentities%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    networkserver\Field22 = $00
    drawloading(0.0, $00, $00, $00)
    reloadholidaysentities()
    For local0 = $00 To $09 Step $01
        tempsounds[local0] = $00
    Next
    If (pausemenuimg <> $00) Then
        freeimage(pausemenuimg)
    EndIf
    If (sprinticon <> $00) Then
        freeimage(sprinticon)
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
    maskimage(pausemenuimg, $FF, $FF, $00)
    scaleimage(pausemenuimg, menuscale, menuscale)
    sprinticon = loadimage_strict("GFX\sprinticon.png")
    blinkicon = loadimage_strict("GFX\blinkicon.png")
    crouchicon = loadimage_strict("GFX\sneakicon.png")
    handicon = loadimage_strict("GFX\handsymbol.png")
    handicon2 = loadimage_strict("GFX\handsymbol2.png")
    staminameterimg = loadimage_strict("GFX\staminameter.jpg")
    keypadhud = loadimage_strict("GFX\keypadhud.jpg")
    maskimage(keypadhud, $FF, $00, $FF)
    panel294 = loadimage_strict("GFX\294panel.jpg")
    maskimage(panel294, $FF, $00, $FF)
    brightness = (Int getinifloat(optionfile, "options", "brightness", 0.0))
    camerafognear = 0.5
    camerafogfar = 6.0
    storedcamerafogfar = camerafogfar
    ambientlightroomtex = createtexture($02, $02, $101, $01)
    textureblend(ambientlightroomtex, $05)
    setbuffer(texturebuffer(ambientlightroomtex, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    ambientlightroomval = $00
    soundemitter = createpivot($00)
    camera = createcamera($00)
    cameraviewport(camera, $00, $00, graphicwidth, graphicheight)
    camerarange(camera, 0.05, camerafogfar)
    camerafogmode(camera, $01)
    camerafogrange(camera, camerafognear, camerafogfar)
    camerafogcolor(camera, (Float getiniint(optionfile, "options", "fog r", $00)), (Float getiniint(optionfile, "options", "fog g", $00)), (Float getiniint(optionfile, "options", "fog b", $00)))
    ambientlight((Float brightness), (Float brightness), (Float brightness))
    screentexs[$00] = createtexture(getcameraquality(camquality), getcameraquality(camquality), $101, $01)
    screentexs[$01] = createtexture(getcameraquality(camquality), getcameraquality(camquality), $101, $01)
    createblurimage()
    cameraprojmode(ark_blur_cam, $00)
    fogtexture = loadtexture_strict("GFX\fog.jpg", $01)
    fog = createsprite(ark_blur_cam)
    scalesprite(fog, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(fog, fogtexture, $00, $00)
    entityblend(fog, $02)
    entityorder(fog, $FFFFFC18)
    moveentity(fog, 0.0, 0.0, 1.0)
    gasmasktexture = loadtexture_strict("GFX\GasmaskOverlay.jpg", $01)
    gasmaskoverlay = createsprite(ark_blur_cam)
    scalesprite(gasmaskoverlay, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(gasmaskoverlay, gasmasktexture, $00, $00)
    entityblend(gasmaskoverlay, $02)
    entityfx(gasmaskoverlay, $01)
    entityorder(gasmaskoverlay, $FFFFFC15)
    moveentity(gasmaskoverlay, 0.0, 0.0, 1.0)
    hideentity(gasmaskoverlay)
    infecttexture = loadtexture_strict("GFX\InfectOverlay.jpg", $01)
    infectoverlay = createsprite(ark_blur_cam)
    scalesprite(infectoverlay, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(infectoverlay, infecttexture, $00, $00)
    entityblend(infectoverlay, $03)
    entityfx(infectoverlay, $01)
    entityorder(infectoverlay, $FFFFFC15)
    moveentity(infectoverlay, 0.0, 0.0, 1.0)
    hideentity(infectoverlay)
    nvtexture = loadtexture_strict("GFX\NightVisionOverlay.jpg", $01)
    nvoverlay = createsprite(ark_blur_cam)
    scalesprite(nvoverlay, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(nvoverlay, nvtexture, $00, $00)
    entityblend(nvoverlay, $02)
    entityfx(nvoverlay, $01)
    entityorder(nvoverlay, $FFFFFC15)
    moveentity(nvoverlay, 0.0, 0.0, 1.0)
    hideentity(nvoverlay)
    nvblink = createsprite(ark_blur_cam)
    scalesprite(nvblink, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitycolor(nvblink, 0.0, 0.0, 0.0)
    entityfx(nvblink, $01)
    entityorder(nvblink, $FFFFFC13)
    moveentity(nvblink, 0.0, 0.0, 1.0)
    hideentity(nvblink)
    fognvtexture = loadtexture_strict("GFX\fogNV.jpg", $01)
    drawloading(5.0, $00, $00, $00)
    darktexture = createtexture((Int smallest_power_two_half), (Int smallest_power_two_half), $03, $01)
    setbuffer(texturebuffer(darktexture, $00))
    cls()
    setbuffer(backbuffer())
    dark = createsprite(ark_blur_cam)
    scalesprite(dark, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(dark, darktexture, $00, $00)
    entityblend(dark, $01)
    entityorder(dark, $FFFFFC16)
    moveentity(dark, 0.0, 0.0, 1.0)
    entityalpha(dark, 0.0)
    lighttexture = createtexture((Int smallest_power_two_half), (Int smallest_power_two_half), $103, $01)
    setbuffer(texturebuffer(lighttexture, $00))
    clscolor($FF, $FF, $FF)
    cls()
    clscolor($00, $00, $00)
    setbuffer(backbuffer())
    teslatexture = loadtexture_strict("GFX\map\tesla.jpg", $03)
    light = createsprite(ark_blur_cam)
    scalesprite(light, 1.0, ((Float graphicheight) / (Float graphicwidth)))
    entitytexture(light, lighttexture, $00, $00)
    entityblend(light, $01)
    entityorder(light, $FFFFFC16)
    moveentity(light, 0.0, 0.0, 1.0)
    hideentity(light)
    initguns()
    lightspritetex($00) = loadtexture_strict("GFX\light1.jpg", $01)
    lightspritetex($01) = loadtexture_strict("GFX\light2.jpg", $01)
    lightspritetex($02) = loadtexture_strict("GFX\lightsprite.jpg", $01)
    drawloading(10.0, $00, $00, $00)
    doorobj = loadmesh_strict("GFX\map\door01.x", $00)
    hideentity(doorobj)
    doorframeobj = loadmesh_strict("GFX\map\doorframe.x", $00)
    hideentity(doorframeobj)
    heavydoorobj($00) = loadmesh_strict("GFX\map\heavydoor1.x", $00)
    hideentity(heavydoorobj($00))
    heavydoorobj($01) = loadmesh_strict("GFX\map\heavydoor2.x", $00)
    hideentity(heavydoorobj($01))
    doorcoll = loadmesh_strict("GFX\map\doorcoll.x", $00)
    hideentity(doorcoll)
    buttonobj = loadmesh_strict("GFX\map\Button.x", $00)
    hideentity(buttonobj)
    buttonkeyobj = loadmesh_strict("GFX\map\ButtonKeycard.x", $00)
    hideentity(buttonkeyobj)
    buttoncodeobj = loadmesh_strict("GFX\map\ButtonCode.x", $00)
    hideentity(buttoncodeobj)
    buttonscannerobj = loadmesh_strict("GFX\map\ButtonScanner.x", $00)
    hideentity(buttonscannerobj)
    bigdoorobj($00) = loadmesh_strict("GFX\map\ContDoorLeft.x", $00)
    hideentity(bigdoorobj($00))
    bigdoorobj($01) = loadmesh_strict("GFX\map\ContDoorRight.x", $00)
    hideentity(bigdoorobj($01))
    leverbaseobj = loadmesh_strict("GFX\map\leverbase.x", $00)
    hideentity(leverbaseobj)
    leverobj = loadmesh_strict("GFX\map\leverhandle.x", $00)
    hideentity(leverobj)
    drawloading(15.0, $00, $00, $00)
    For local0 = $00 To $05 Step $01
        gorepics(local0) = loadtexture_strict((("GFX\895pics\pic" + (Str (local0 + $01))) + ".jpg"), $01)
    Next
    oldaipics($00) = loadtexture_strict("GFX\AIface.jpg", $01)
    oldaipics($01) = loadtexture_strict("GFX\AIface2.jpg", $01)
    drawloading(20.0, $00, $00, $00)
    For local0 = $00 To $06 Step $01
        decaltextures(local0) = loadtexture_strict((("GFX\decal" + (Str (local0 + $01))) + ".png"), $03)
    Next
    decaltextures($07) = loadtexture_strict("GFX\items\INVpaperstrips.jpg", $03)
    For local0 = $08 To $0C Step $01
        decaltextures(local0) = loadtexture_strict((("GFX\decalpd" + (Str (local0 - $07))) + ".jpg"), $03)
    Next
    For local0 = $0D To $0E Step $01
        decaltextures(local0) = loadtexture_strict((("GFX\bullethole" + (Str (local0 - $0C))) + ".jpg"), $03)
    Next
    For local0 = $0F To $10 Step $01
        decaltextures(local0) = loadtexture_strict((("GFX\blooddrop" + (Str (local0 - $0E))) + ".png"), $03)
    Next
    decaltextures($11) = loadtexture_strict("GFX\decal8.png", $03)
    decaltextures($12) = loadtexture_strict("GFX\decalpd6.dc", $03)
    decaltextures($13) = loadtexture_strict("GFX\decal19.png", $03)
    decaltextures($14) = loadtexture_strict("GFX\decal427.png", $03)
    particletextures($00) = loadtexture_strict("GFX\smoke.png", $03)
    particletextures($01) = loadtexture_strict("GFX\flash.jpg", $03)
    particletextures($02) = loadtexture_strict("GFX\dust.jpg", $03)
    particletextures($03) = loadtexture_strict("GFX\npcs\hg.pt", $03)
    particletextures($04) = loadtexture_strict("GFX\map\sun.jpg", $03)
    particletextures($05) = loadtexture_strict("GFX\bloodsprite.png", $03)
    particletextures($06) = loadtexture_strict("GFX\smoke2.png", $03)
    particletextures($07) = loadtexture_strict("GFX\spark.jpg", $03)
    particletextures($08) = loadtexture_strict("GFX\particle.png", $03)
    drawloading(25.0, $00, $00, $00)
    monitor = loadmesh_strict("GFX\map\monitor.b3d", $00)
    hideentity(monitor)
    monitortexture = loadtexture_strict("GFX\monitortexture.jpg", $01)
    cambaseobj = loadmesh_strict("GFX\map\cambase.x", $00)
    hideentity(cambaseobj)
    camobj = loadmesh_strict("GFX\map\CamHead.b3d", $00)
    hideentity(camobj)
    monitor2 = loadmesh_strict("GFX\map\monitor_checkpoint.b3d", $00)
    hideentity(monitor2)
    monitor3 = loadmesh_strict("GFX\map\monitor_checkpoint.b3d", $00)
    hideentity(monitor3)
    monitortexture2 = loadtexture_strict("GFX\map\LockdownScreen2.jpg", $01)
    monitortexture3 = loadtexture_strict("GFX\map\LockdownScreen.jpg", $01)
    monitortexture4 = loadtexture_strict("GFX\map\LockdownScreen3.jpg", $01)
    monitortextureoff = createtexture($01, $01, $00, $01)
    setbuffer(texturebuffer(monitortextureoff, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    lightconemodel = loadmesh_strict("GFX\lightcone.b3d", $00)
    hideentity(lightconemodel)
    For local0 = $02 To countsurfaces(monitor2) Step $01
        local1 = getsurface(monitor2, local0)
        local2 = getsurfacebrush(local1)
        If (local2 <> $00) Then
            local3 = getbrushtexture(local2, $00)
            If (local3 <> $00) Then
                local4 = strippath(texturename(local3))
                If (lower(local4) <> "monitortexture.jpg") Then
                    brushtexture(local2, monitortextureoff, $00, $00)
                    paintsurface(local1, local2)
                EndIf
                If (local4 <> "") Then
                    freetexture(local3)
                EndIf
            EndIf
            freebrush(local2)
        EndIf
    Next
    For local0 = $02 To countsurfaces(monitor3) Step $01
        local1 = getsurface(monitor3, local0)
        local2 = getsurfacebrush(local1)
        If (local2 <> $00) Then
            local3 = getbrushtexture(local2, $00)
            If (local3 <> $00) Then
                local4 = strippath(texturename(local3))
                If (lower(local4) <> "monitortexture.jpg") Then
                    brushtexture(local2, monitortextureoff, $00, $00)
                    paintsurface(local1, local2)
                EndIf
                If (local4 <> "") Then
                    freetexture(local3)
                EndIf
            EndIf
            freebrush(local2)
        EndIf
    Next
    usertrackmusicamount = $00
    If (enableusertracks <> 0) Then
        local5 = "SFX\Radio\UserTracks\"
        If (filetype(local5) <> $02) Then
            createdir(local5)
        EndIf
        local6 = readdir("SFX\Radio\UserTracks\")
        Repeat
            local7 = nextfile(local6)
            If (local7 = "") Then
                Exit
            EndIf
            If (filetype(("SFX\Radio\UserTracks\" + local7)) = $01) Then
                local8 = loadsound(("SFX\Radio\UserTracks\" + local7))
                If (local8 <> $00) Then
                    usertrackname(usertrackmusicamount) = local7
                    usertrackmusicamount = (usertrackmusicamount + $01)
                EndIf
                freesound(local8)
            EndIf
        Forever
        closedir(local6)
    EndIf
    If (enableusertracks <> 0) Then
        debuglog(("User Tracks found: " + (Str usertrackmusicamount)))
    EndIf
    inititemtemplates()
    setchunkdatavalues()
    For local0 = $01 To $0B Step $01
        dtextures[local0] = copyentity(classdobj, $00)
        hideentity(dtextures[local0])
    Next
    local9 = loadtexture_strict("GFX\npcs\gonzales.jpg", $01)
    entitytexture(dtextures[$01], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\corpse.jpg", $01)
    entitytexture(dtextures[$02], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\scientist.jpg", $01)
    entitytexture(dtextures[$03], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\scientist2.jpg", $01)
    entitytexture(dtextures[$04], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\janitor.jpg", $01)
    entitytexture(dtextures[$05], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\106victim.jpg", $01)
    entitytexture(dtextures[$06], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\classd2.jpg", $01)
    entitytexture(dtextures[$07], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\035victim.jpg", $01)
    entitytexture(dtextures[$08], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\body2.jpg", $01)
    entitytexture(dtextures[$09], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\classd3.jpg", $01)
    entitytexture(dtextures[$0A], local9, $00, $00)
    freetexture(local9)
    local9 = loadtexture_strict("GFX\npcs\body1.jpg", $01)
    entitytexture(dtextures[$0B], local9, $00, $00)
    freetexture(local9)
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
    texturelodbias(texturefloat)
    initparticles(camera)
    particleeffect[$00] = createtemplate()
    settemplateemitterblend(particleeffect[$00], $03)
    settemplateinterval(particleeffect[$00], $01)
    settemplateparticlesperinterval(particleeffect[$00], $06)
    settemplateemitterlifetime(particleeffect[$00], $06)
    settemplateparticlelifetime(particleeffect[$00], $14, $1E)
    settemplatetexture(particleeffect[$00], "GFX\Spark.png", $02, $03)
    settemplateoffset(particleeffect[$00], -0.1, 0.1, -0.1, 0.1, -0.1, 0.1)
    settemplatevelocity(particleeffect[$00], -0.0375, 0.0375, -0.0375, 0.0375, -0.0375, 0.0375)
    settemplatealigntofall(particleeffect[$00], $01, $2D)
    settemplategravity(particleeffect[$00], 0.001)
    settemplatealphavel(particleeffect[$00], $01)
    settemplatesize(particleeffect[$00], (1.0 / 32.0), (1.0 / 16.0), 0.7, 1.0)
    settemplatecolors(particleeffect[$00], $FF, $6565FF)
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
    settemplateinterval(particleeffect[$05], $0E)
    settemplateparticlesperinterval(particleeffect[$05], $04)
    settemplateemitterlifetime(particleeffect[$05], $190)
    settemplateparticlelifetime(particleeffect[$05], $C8, $DC)
    settemplatetexture(particleeffect[$05], "GFX\smoke2.png", $02, $01)
    settemplateoffset(particleeffect[$05], -0.1, 0.1, 0.9, 0.9, -0.1, 0.1)
    settemplatevelocity(particleeffect[$05], -0.0175, 0.0175, 0.001, 0.001, -0.0175, 0.0075)
    settemplategravity(particleeffect[$05], 0.0)
    settemplatealphavel(particleeffect[$05], $01)
    settemplatesize(particleeffect[$05], 1.5, 1.3, 1.0, 1.0)
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
    local10 = createtemplate()
    settemplateemitterblend(local10, $01)
    settemplateinterval(local10, $01)
    settemplateemitterlifetime(local10, $03)
    settemplateparticlelifetime(local10, $1E, $2D)
    settemplatetexture(local10, "GFX\smoke2.png", $02, $01)
    settemplateoffset(local10, -0.1, 0.1, -0.1, 0.1, -0.1, 0.1)
    settemplatevelocity(local10, -0.005, 0.005, 0.0, -0.03, -0.005, 0.005)
    settemplatealphavel(local10, $01)
    settemplatesize(local10, 0.4, 0.4, 0.5, 1.5)
    settemplatesizevel(local10, 0.01, 1.01)
    settemplategravity(particleeffect[$02], 0.005)
    settemplatesubtemplate(particleeffect[$02], local10, $00)
    room2slcam = createcamera($00)
    cameraviewport(room2slcam, $00, $00, $80, $80)
    camerarange(room2slcam, 0.05, 6.0)
    camerazoom(room2slcam, 0.8)
    hideentity(room2slcam)
    networkserver\Field22 = $01
    drawloading(30.0, $00, $00, $00)
    Return $00
End Function
