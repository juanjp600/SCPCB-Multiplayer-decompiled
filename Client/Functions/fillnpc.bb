Function fillnpc%(arg0.npcs, arg1%)
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.npcs
    Local local7%
    Local local8%
    If (networkserver\Field12 = $01) Then
        Return $00
    EndIf
    Select arg1
        Case $01
            arg0\Field43 = "SCP-173"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.23, 0.32)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field8 = $01
            arg0\Field0 = copyentity(g_model\Field13, $00)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-173", "scale", 0.0) / meshdepth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            nameentityex(arg0, "173")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-173", "speed", 0.0) * 0.01)
            arg0\Field1 = loadmesh_strict("GFX\173box.b3d", $00)
            scaleentity(arg0\Field1, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            hideentity(arg0\Field1)
            arg0\Field70 = 0.32
            curr173 = arg0
        Case $02
            arg0\Field43 = "SCP-106"
            arg0\Field4 = createpivot($00)
            arg0\Field44 = 0.0
            arg0\Field45 = 0.0
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field18, $00)
            nameentityex(arg0, "106")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-106", "scale", 0.0) / 2.2)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-106", "speed", 0.0) * 0.01)
            curr106 = arg0
        Case $03
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field11, $00)
            nameentityex(arg0, "guard")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "Guard", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "Guard", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(g_model\Field11)), (- meshheight(g_model\Field11)), (- meshdepth(g_model\Field11)), (meshwidth(g_model\Field11) * 2.0), (meshheight(g_model\Field11) * 2.0), (meshdepth(g_model\Field11) * 2.0))
        Case $08
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field8, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "MTF", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "MTF", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(g_model\Field8)), (- meshheight(g_model\Field8)), (- meshdepth(g_model\Field8)), (meshwidth(g_model\Field8) * 2.0), (meshheight(g_model\Field8) * 2.0), (meshdepth(g_model\Field8) * 2.0))
            nameentityex(arg0, "mtf")
            If (mtfsfx($00) = $00) Then
                mtfsfx($00) = loadsound_strict("SFX\Character\MTF\ClassD1.ogg")
                mtfsfx($01) = loadsound_strict("SFX\Character\MTF\ClassD2.ogg")
                mtfsfx($02) = loadsound_strict("SFX\Character\MTF\ClassD3.ogg")
                mtfsfx($03) = loadsound_strict("SFX\Character\MTF\ClassD4.ogg")
                mtfsfx($05) = loadsound_strict("SFX\Character\MTF\Beep.ogg")
                mtfsfx($06) = loadsound_strict("SFX\Character\MTF\Breath.ogg")
            EndIf
        Case $04
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.32, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field4, $00)
            nameentityex(arg0, "classd")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(g_model\Field4)), (- meshheight(g_model\Field4)), (- meshdepth(g_model\Field4)), (meshwidth(g_model\Field4) * 2.0), (meshheight(g_model\Field4) * 2.0), (meshdepth(g_model\Field4) * 2.0))
            arg0\Field70 = 0.32
        Case $17
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.32, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field4, $00)
            nameentityex(arg0, "classd")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(g_model\Field4)), (- meshheight(g_model\Field4)), (- meshdepth(g_model\Field4)), (meshwidth(g_model\Field4) * 2.0), (meshheight(g_model\Field4) * 2.0), (meshdepth(g_model\Field4) * 2.0))
            arg0\Field70 = 0.32
        Case $06
            arg0\Field43 = "SCP-372"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = loadanimmesh_strict("GFX\npcs\372.b3d", $00)
            nameentityex(arg0, "372")
            local1 = (0.35 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
        Case $0C
            arg0\Field43 = "SCP-513-1"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = loadanimmesh_strict("GFX\npcs\bll.b3d", $00)
            nameentityex(arg0, "5131")
            arg0\Field1 = copyentity(arg0\Field0, $00)
            entityalpha(arg0\Field1, 0.6)
            local1 = (1.8 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            scaleentity(arg0\Field1, local1, local1, local1, $00)
            curr5131 = arg0
        Case $09
            arg0\Field43 = "SCP-096"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.26, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field15, $00)
            nameentityex(arg0, "096")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-096", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-096", "scale", 0.0) / 3.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, ((- meshwidth(arg0\Field0)) * 2.0), ((- meshheight(arg0\Field0)) * 2.0), ((- meshdepth(arg0\Field0)) * 2.0), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 4.0), (meshdepth(arg0\Field0) * 4.0))
            arg0\Field70 = 0.26
            curr096 = arg0
        Case $0A
            arg0\Field43 = "SCP-049"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field20, $00)
            nameentityex(arg0, "049")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-049", "speed", 0.0) / 100.0)
            local1 = getinifloat("DATA\NPCs.ini", "SCP-049", "scale", 0.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field16 = loadsound_strict("SFX\Horror\Horror12.ogg")
            If (horrorsfx($0D) = $00) Then
                horrorsfx($0D) = loadsound_strict("SFX\Horror\Horror13.ogg")
            EndIf
        Case $0B
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field16, $00)
            nameentityex(arg0, "zombie")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-049-2", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(arg0\Field0)), (- meshheight(arg0\Field0)), (- meshdepth(arg0\Field0)), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 2.0), (meshdepth(arg0\Field0) * 2.0))
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-049-2", "speed", 0.0) / 100.0)
            setanimtime(arg0\Field0, 107.0, $00)
            arg0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            arg0\Field61 = $64
            entitypickmode(arg0\Field0, $02, $01)
        Case $07
            arg0\Field43 = "Human"
            arg0\Field44 = 0.0
            arg0\Field45 = 0.0
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = copyentity(g_model\Field12[$00], $00)
            arg0\Field1 = copyentity(g_model\Field12[$01], $00)
            entityparent(arg0\Field1, arg0\Field0, $01)
            nameentityex(arg0, "apache")
            For local2 = $FFFFFFFF To $01 Step $02
                local3 = copyentity(arg0\Field1, arg0\Field1)
                rotateentity(local3, 0.0, (4.0 * (Float local2)), 0.0, $00)
                entityalpha(local3, 0.5)
            Next
            arg0\Field2 = loadanimmesh_strict("GFX\apacherotor2.b3d", arg0\Field0)
            positionentity(arg0\Field2, 0.0, 2.15, -5.48, $00)
            entitytype(arg0\Field4, $04, $00)
            entityradius(arg0\Field4, 3.0, 0.0)
            For local2 = $FFFFFFFF To $01 Step $02
                local4 = createlight($02, arg0\Field0)
                lightrange(local4, 2.0)
                lightcolor(local4, 255.0, 255.0, 255.0)
                positionentity(local4, (1.65 * (Float local2)), 1.17, -0.25, $00)
                local5 = createsprite(arg0\Field0)
                positionentity(local5, (1.65 * (Float local2)), 1.17, 0.0, $00)
                scalesprite(local5, 0.13, 0.13)
                entitytexture(local5, lightspritetex($00), $00, $00)
                entityblend(local5, $03)
                entityfx(local5, $09)
            Next
            local1 = 0.6
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            entitypickmode(arg0\Field0, $02, $01)
        Case $0D
            arg0\Field43 = "Unidentified"
            arg0\Field4 = createpivot($00)
            For local6 = Each npcs
                If (((arg0\Field5 = local6\Field5) And (arg0 <> local6)) <> 0) Then
                    arg0\Field0 = copyentity(local6\Field0, $00)
                    Exit
                EndIf
            Next
            If (arg0\Field0 = $00) Then
                arg0\Field0 = loadanimmesh_strict("GFX\NPCs\035tentacle.b3d", $00)
                scaleentity(arg0\Field0, 0.065, 0.065, 0.065, $00)
            EndIf
            nameentityex(arg0, "tent")
            setanimtime(arg0\Field0, 283.0, $00)
        Case $0E
            arg0\Field43 = "Unidentified"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.25, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field21, $00)
            entityfx(arg0\Field0, $01)
            local7 = loadtexture_strict("GFX\npcs\860_eyes.png", $03)
            nameentityex(arg0, "860")
            arg0\Field1 = createsprite($00)
            scalesprite(arg0\Field1, 0.1, 0.1)
            entitytexture(arg0\Field1, local7, $00, $00)
            freetexture(local7)
            entityfx(arg0\Field1, $09)
            entityorder(arg0\Field1, $FFFFFFFF)
            entityblend(arg0\Field1, $03)
            spriteviewmode(arg0\Field1, $02)
            positionentity(arg0\Field1, 9999.0, 999.0, 9999.0, $01)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "forestmonster", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "forestmonster", "scale", 0.0) / 20.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, ((- meshwidth(arg0\Field0)) * 2.0), ((- meshheight(arg0\Field0)) * 2.0), ((- meshdepth(arg0\Field0)) * 2.0), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 4.0), (meshdepth(arg0\Field0) * 4.0))
            arg0\Field70 = 0.25
        Case $0F
            local8 = $00
            For local6 = Each npcs
                If (((arg0\Field5 = local6\Field5) And (arg0 <> local6)) <> 0) Then
                    local8 = (local8 + $01)
                EndIf
            Next
            If (local8 = $00) Then
                local2 = $35
            EndIf
            If (local8 = $01) Then
                local2 = $59
            EndIf
            If (local8 = $02) Then
                local2 = $60
            EndIf
            arg0\Field43 = ("SCP-939-" + (Str local2))
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.3, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field19, $00)
            nameentityex(arg0, "939")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-939", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-939", "speed", 0.0) / 100.0)
            arg0\Field70 = 0.3
        Case $10
            arg0\Field43 = "SCP-066"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = loadanimmesh_strict("GFX\NPCs\scp-066.b3d", $00)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-066", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            nameentityex(arg0, "066")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-066", "speed", 0.0) / 100.0)
        Case $12
            local2 = $01
            For local6 = Each npcs
                If (((arg0\Field5 = local6\Field5) And (arg0 <> local6)) <> 0) Then
                    local2 = (local2 + $01)
                EndIf
            Next
            arg0\Field43 = ("SCP-966-" + (Str local2))
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = copyentity(g_model\Field22, $00)
            entityfx(arg0\Field0, $01)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-966", "scale", 0.0) / 40.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            nameentityex(arg0, "966")
            setanimtime(arg0\Field0, 15.0, $00)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-966", "speed", 0.0) / 100.0)
        Case $13
            arg0\Field43 = "SCP-1048-A"
            arg0\Field0 = loadanimmesh_strict("GFX\npcs\scp-1048a.b3d", $00)
            scaleentity(arg0\Field0, 0.05, 0.05, 0.05, $00)
            setanimtime(arg0\Field0, 2.0, $00)
            arg0\Field16 = loadsound_strict("SFX\SCP\1048A\Shriek.ogg")
            arg0\Field19 = loadsound_strict("SFX\SCP\1048A\Growth.ogg")
            nameentityex(arg0, "1048")
        Case $14
            arg0\Field43 = "Unidentified"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            For local6 = Each npcs
                If (((arg0\Field5 = local6\Field5) And (arg0 <> local6)) <> 0) Then
                    arg0\Field0 = copyentity(local6\Field0, $00)
                    Exit
                EndIf
            Next
            If (arg0\Field0 = $00) Then
                arg0\Field0 = loadanimmesh_strict("GFX\npcs\1499-1.b3d", $00)
            EndIf
            nameentityex(arg0, "1499")
            arg0\Field21 = ((getinifloat("DATA\NPCs.ini", "SCP-1499-1", "speed", 0.0) / 100.0) * rnd(0.9, 1.1))
            local1 = ((getinifloat("DATA\NPCs.ini", "SCP-1499-1", "scale", 0.0) / 4.0) * rnd(0.8, 1.0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            entityfx(arg0\Field0, $01)
            entityautofade(arg0\Field0, (hidedistance * 2.5), (hidedistance * 2.95))
        Case $15
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field17, $00)
            nameentityex(arg0, "008")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(arg0\Field0)), (- meshheight(arg0\Field0)), (- meshdepth(arg0\Field0)), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 2.0), (meshdepth(arg0\Field0) * 2.0))
            setnpcframe(arg0, 11.0)
            arg0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            arg0\Field61 = $78
            entitypickmode(arg0\Field0, $02, $01)
        Case $16
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.32, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(g_model\Field5, $00)
            nameentityex(arg0, "clerk")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(g_model\Field5)), (- meshheight(g_model\Field5)), (- meshdepth(g_model\Field5)), (meshwidth(g_model\Field5) * 2.0), (meshheight(g_model\Field5) * 2.0), (meshdepth(g_model\Field5) * 2.0))
            arg0\Field70 = 0.32
    End Select
    applyreflection(arg0\Field0)
    Return $00
End Function
