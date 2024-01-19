Function loadentities%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16$
    Local local17%
    Local local18#
    Local local19%
    For local0 = $00 To $09 Step $01
        tempsounds[local0] = $00
    Next
    local1 = loadimage_strict("GFX\menu\pausemenu.jpg")
    maskimage(local1, $FF, $FF, $00)
    scaleimage(local1, menuscale, menuscale)
    local2 = loadimage_strict("GFX\sprinticon.png")
    local3 = loadimage_strict("GFX\blinkicon.png")
    local4 = loadimage_strict("GFX\sneakicon.png")
    local5 = loadimage_strict("GFX\handsymbol.png")
    local6 = loadimage_strict("GFX\handsymbol2.png")
    local7 = loadimage_strict("GFX\staminameter.jpg")
    local8 = loadimage_strict("GFX\keypadhud.jpg")
    maskimage(local8, $FF, $00, $FF)
    local9 = loadimage_strict("GFX\294panel.jpg")
    maskimage(local9, $FF, $00, $FF)
    brightness = $00
    camerafognear = 0.5
    camerafogfar = 6.0
    storedcamerafogfar = camerafogfar
    ambientlightroomtex = createtexture($02, $02, $101, $01)
    textureblend(ambientlightroomtex, $05)
    setbuffer(texturebuffer(ambientlightroomtex, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    local10 = $00
    soundemitter = createpivot($00)
    screentexs[$00] = createtexture($200, $200, $01, $01)
    screentexs[$01] = createtexture($200, $200, $01, $01)
    camera = createcamera($00)
    cameraviewport(camera, $00, $00, $500, $2D0)
    camerarange(camera, 0.05, 1000.0)
    camerafogmode(camera, $01)
    camerafogrange(camera, 0.05, 1000.0)
    fogtexture = loadtexture_strict("GFX\fog.jpg", $01)
    fog = createsprite(ark_blur_cam)
    scalesprite(fog, max(((Float local11) / 1240.0), 1.0), max((((Float local12) / 960.0) * 0.8), 0.8))
    entitytexture(fog, fogtexture, $00, $00)
    entityblend(fog, $02)
    entityorder(fog, $FFFFFC18)
    moveentity(fog, 0.0, 0.0, 1.0)
    gasmasktexture = loadtexture_strict("GFX\GasmaskOverlay.jpg", $01)
    gasmaskoverlay = createsprite(ark_blur_cam)
    scalesprite(gasmaskoverlay, max(((Float local11) / 1024.0), 1.0), max((((Float local12) / 1024.0) * 0.8), 0.8))
    entitytexture(gasmaskoverlay, gasmasktexture, $00, $00)
    entityblend(gasmaskoverlay, $02)
    entityfx(gasmaskoverlay, $01)
    entityorder(gasmaskoverlay, $FFFFFC15)
    moveentity(gasmaskoverlay, 0.0, 0.0, 1.0)
    hideentity(gasmaskoverlay)
    infecttexture = loadtexture_strict("GFX\InfectOverlay.jpg", $01)
    infectoverlay = createsprite(ark_blur_cam)
    scalesprite(infectoverlay, max(((Float local11) / 1024.0), 1.0), max((((Float local12) / 1024.0) * 0.8), 0.8))
    entitytexture(infectoverlay, infecttexture, $00, $00)
    entityblend(infectoverlay, $03)
    entityfx(infectoverlay, $01)
    entityorder(infectoverlay, $FFFFFC15)
    moveentity(infectoverlay, 0.0, 0.0, 1.0)
    hideentity(infectoverlay)
    nvtexture = loadtexture_strict("GFX\NightVisionOverlay.jpg", $01)
    nvoverlay = createsprite(ark_blur_cam)
    scalesprite(nvoverlay, max(((Float local11) / 1024.0), 1.0), max((((Float local12) / 1024.0) * 0.8), 0.8))
    entitytexture(nvoverlay, nvtexture, $00, $00)
    entityblend(nvoverlay, $02)
    entityfx(nvoverlay, $01)
    entityorder(nvoverlay, $FFFFFC15)
    moveentity(nvoverlay, 0.0, 0.0, 1.0)
    hideentity(nvoverlay)
    nvblink = createsprite(ark_blur_cam)
    scalesprite(nvblink, max(((Float local11) / 1024.0), 1.0), max((((Float local12) / 1024.0) * 0.8), 0.8))
    entitycolor(nvblink, 0.0, 0.0, 0.0)
    entityfx(nvblink, $01)
    entityorder(nvblink, $FFFFFC13)
    moveentity(nvblink, 0.0, 0.0, 1.0)
    hideentity(nvblink)
    fognvtexture = loadtexture_strict("GFX\fogNV.jpg", $01)
    darktexture = createtexture($400, $400, $03, $01)
    setbuffer(texturebuffer(darktexture, $00))
    cls()
    setbuffer(backbuffer())
    dark = createsprite(camera)
    scalesprite(dark, max(((Float local11) / 1240.0), 1.0), max((((Float local12) / 960.0) * 0.8), 0.8))
    entitytexture(dark, darktexture, $00, $00)
    entityblend(dark, $01)
    entityorder(dark, $FFFFFC16)
    moveentity(dark, 0.0, 0.0, 1.0)
    entityalpha(dark, 0.0)
    lighttexture = createtexture($400, $400, $03, $01)
    setbuffer(texturebuffer(lighttexture, $00))
    clscolor($FF, $FF, $FF)
    cls()
    clscolor($00, $00, $00)
    setbuffer(backbuffer())
    teslatexture = loadtexture_strict("GFX\map\tesla.jpg", $03)
    light = createsprite(camera)
    scalesprite(light, max(((Float local11) / 1240.0), 1.0), max((((Float local12) / 960.0) * 0.8), 0.8))
    entitytexture(light, lighttexture, $00, $00)
    entityblend(light, $01)
    entityorder(light, $FFFFFC16)
    moveentity(light, 0.0, 0.0, 1.0)
    hideentity(light)
    lightspritetex($00) = loadtexture_strict("GFX\light1.jpg", $01)
    lightspritetex($01) = loadtexture_strict("GFX\light2.jpg", $01)
    lightspritetex($02) = loadtexture_strict("GFX\lightsprite.jpg", $01)
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
    For local0 = $00 To $05 Step $01
        gorepics(local0) = loadtexture_strict((("GFX\895pics\pic" + (Str (local0 + $01))) + ".jpg"), $01)
    Next
    oldaipics($00) = loadtexture_strict("GFX\AIface.jpg", $01)
    oldaipics($01) = loadtexture_strict("GFX\AIface2.jpg", $01)
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
        local13 = getsurface(monitor2, local0)
        local14 = getsurfacebrush(local13)
        If (local14 <> $00) Then
            local15 = getbrushtexture(local14, $00)
            If (local15 <> $00) Then
                local16 = strippath(texturename(local15))
                If (lower(local16) <> "monitortexture.jpg") Then
                    brushtexture(local14, monitortextureoff, $00, $00)
                    paintsurface(local13, local14)
                EndIf
                If (local16 <> "") Then
                    freetexture(local15)
                EndIf
            EndIf
            freebrush(local14)
        EndIf
    Next
    For local0 = $02 To countsurfaces(monitor3) Step $01
        local13 = getsurface(monitor3, local0)
        local14 = getsurfacebrush(local13)
        If (local14 <> $00) Then
            local15 = getbrushtexture(local14, $00)
            If (local15 <> $00) Then
                local16 = strippath(texturename(local15))
                If (lower(local16) <> "monitortexture.jpg") Then
                    brushtexture(local14, monitortextureoff, $00, $00)
                    paintsurface(local13, local14)
                EndIf
                If (local16 <> "") Then
                    freetexture(local15)
                EndIf
            EndIf
            freebrush(local14)
        EndIf
    Next
    inititemtemplates()
    setchunkdatavalues()
    For local0 = $01 To $0B Step $01
        dtextures[local0] = copyentity(classdobj, $00)
        hideentity(dtextures[local0])
    Next
    local17 = loadtexture_strict("GFX\npcs\gonzales.jpg", $01)
    entitytexture(dtextures[$01], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\corpse.jpg", $01)
    entitytexture(dtextures[$02], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\scientist.jpg", $01)
    entitytexture(dtextures[$03], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\scientist2.jpg", $01)
    entitytexture(dtextures[$04], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\janitor.jpg", $01)
    entitytexture(dtextures[$05], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\106victim.jpg", $01)
    entitytexture(dtextures[$06], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\classd2.jpg", $01)
    entitytexture(dtextures[$07], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\035victim.jpg", $01)
    entitytexture(dtextures[$08], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\body2.jpg", $01)
    entitytexture(dtextures[$09], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\classd3.jpg", $01)
    entitytexture(dtextures[$0A], local17, $00, $00)
    freetexture(local17)
    local17 = loadtexture_strict("GFX\npcs\body1.jpg", $01)
    entitytexture(dtextures[$0B], local17, $00, $00)
    freetexture(local17)
    loadmaterials("Data\materials.ini")
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
    texturelodbias(local18)
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
    local19 = createtemplate()
    settemplateemitterblend(local19, $01)
    settemplateinterval(local19, $01)
    settemplateemitterlifetime(local19, $03)
    settemplateparticlelifetime(local19, $1E, $2D)
    settemplatetexture(local19, "GFX\smoke2.png", $02, $01)
    settemplateoffset(local19, -0.1, 0.1, -0.1, 0.1, -0.1, 0.1)
    settemplatevelocity(local19, -0.005, 0.005, 0.0, -0.03, -0.005, 0.005)
    settemplatealphavel(local19, $01)
    settemplatesize(local19, 0.4, 0.4, 0.5, 1.5)
    settemplatesizevel(local19, 0.01, 1.01)
    settemplategravity(particleeffect[$02], 0.005)
    settemplatesubtemplate(particleeffect[$02], local19, $00)
    Return $00
End Function