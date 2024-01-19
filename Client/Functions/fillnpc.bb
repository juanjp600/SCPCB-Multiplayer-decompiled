Function fillnpc%(arg0.npcs, arg1%)
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7.npcs
    Local local8%
    Local local9%
    Select arg1
        Case $01
            arg0\Field43 = "SCP-173"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.23, 0.32)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field8 = $01
            arg0\Field0 = copyentity(object_173, $00)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-173", "scale", 0.0) / meshdepth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            nameentityex(arg0, "173")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-173", "speed", 0.0) / 100.0)
            arg0\Field1 = loadmesh_strict("GFX\173box.b3d", $00)
            scaleentity(arg0\Field1, roomscale, roomscale, roomscale, $00)
            hideentity(arg0\Field1)
            arg0\Field68 = 0.32
            curr173 = arg0
        Case $02
            arg0\Field43 = "SCP-106"
            arg0\Field4 = createpivot($00)
            arg0\Field44 = 0.0
            arg0\Field45 = 0.0
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(npc106obj, $00)
            nameentityex(arg0, "106")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-106", "scale", 0.0) / 2.2)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            local2 = loadtexture_strict("GFX\npcs\oldmaneyes.jpg", $01)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-106", "speed", 0.0) / 100.0)
            arg0\Field1 = createsprite($00)
            scalesprite(arg0\Field1, 0.03, 0.03)
            entitytexture(arg0\Field1, local2, $00, $00)
            entityblend(arg0\Field1, $03)
            entityfx(arg0\Field1, $09)
            spriteviewmode(arg0\Field1, $02)
            freetexture(local2)
            curr106 = arg0
        Case $03
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(guardobj, $00)
            nameentityex(arg0, "guard")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "Guard", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "Guard", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(guardobj)), (- meshheight(guardobj)), (- meshdepth(guardobj)), (meshwidth(guardobj) * 2.0), (meshheight(guardobj) * 2.0), (meshdepth(guardobj) * 2.0))
        Case $08
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(mtfobj, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "MTF", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "MTF", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(mtfobj)), (- meshheight(mtfobj)), (- meshdepth(mtfobj)), (meshwidth(mtfobj) * 2.0), (meshheight(mtfobj) * 2.0), (meshdepth(mtfobj) * 2.0))
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
            arg0\Field0 = copyentity(classdobj, $00)
            nameentityex(arg0, "classd")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(classdobj)), (- meshheight(classdobj)), (- meshdepth(classdobj)), (meshwidth(classdobj) * 2.0), (meshheight(classdobj) * 2.0), (meshdepth(classdobj) * 2.0))
            arg0\Field68 = 0.32
        Case $17
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.32, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(classdobj, $00)
            nameentityex(arg0, "classd")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(classdobj)), (- meshheight(classdobj)), (- meshdepth(classdobj)), (meshwidth(classdobj) * 2.0), (meshheight(classdobj) * 2.0), (meshdepth(classdobj) * 2.0))
            arg0\Field68 = 0.32
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
            arg0\Field0 = copyentity(object_096, $00)
            nameentityex(arg0, "096")
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-096", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-096", "scale", 0.0) / 3.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, ((- meshwidth(arg0\Field0)) * 2.0), ((- meshheight(arg0\Field0)) * 2.0), ((- meshdepth(arg0\Field0)) * 2.0), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 4.0), (meshdepth(arg0\Field0) * 4.0))
            arg0\Field68 = 0.26
            curr096 = arg0
        Case $0A
            arg0\Field43 = "SCP-049"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(npc049obj, $00)
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
            arg0\Field0 = copyentity(npc0492obj, $00)
            nameentityex(arg0, "zombie")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-049-2", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, (- meshwidth(arg0\Field0)), (- meshheight(arg0\Field0)), (- meshdepth(arg0\Field0)), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 2.0), (meshdepth(arg0\Field0) * 2.0))
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-049-2", "speed", 0.0) / 100.0)
            setanimtime(arg0\Field0, 107.0, $00)
            arg0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            arg0\Field59 = $64
            entitypickmode(arg0\Field0, $02, $01)
        Case $07
            arg0\Field43 = "Human"
            arg0\Field44 = 0.0
            arg0\Field45 = 0.0
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = copyentity(apacheobj, $00)
            arg0\Field1 = copyentity(apacherotorobj, $00)
            entityparent(arg0\Field1, arg0\Field0, $01)
            nameentityex(arg0, "apache")
            For local3 = $FFFFFFFF To $01 Step $02
                local4 = copyentity(arg0\Field1, arg0\Field1)
                rotateentity(local4, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local4, 0.5)
            Next
            arg0\Field2 = loadanimmesh_strict("GFX\apacherotor2.b3d", arg0\Field0)
            positionentity(arg0\Field2, 0.0, 2.15, -5.48, $00)
            entitytype(arg0\Field4, $04, $00)
            entityradius(arg0\Field4, 3.0, 0.0)
            For local3 = $FFFFFFFF To $01 Step $02
                local5 = createlight($02, arg0\Field0)
                lightrange(local5, 2.0)
                lightcolor(local5, 255.0, 255.0, 255.0)
                positionentity(local5, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local6 = createsprite(arg0\Field0)
                positionentity(local6, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local6, 0.13, 0.13)
                entitytexture(local6, lightspritetex($00), $00, $00)
                entityblend(local6, $03)
                entityfx(local6, $09)
            Next
            local1 = 0.6
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            entitypickmode(arg0\Field0, $02, $01)
        Case $0D
            arg0\Field43 = "Unidentified"
            arg0\Field4 = createpivot($00)
            For local7 = Each npcs
                If (((arg0\Field5 = local7\Field5) And (arg0 <> local7)) <> 0) Then
                    arg0\Field0 = copyentity(local7\Field0, $00)
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
            arg0\Field0 = copyentity(object_860, $00)
            entityfx(arg0\Field0, $01)
            local8 = loadtexture_strict("GFX\npcs\860_eyes.png", $03)
            nameentityex(arg0, "860")
            arg0\Field1 = createsprite($00)
            scalesprite(arg0\Field1, 0.1, 0.1)
            entitytexture(arg0\Field1, local8, $00, $00)
            freetexture(local8)
            entityfx(arg0\Field1, $09)
            entityblend(arg0\Field1, $03)
            spriteviewmode(arg0\Field1, $02)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "forestmonster", "speed", 0.0) / 100.0)
            local1 = (getinifloat("DATA\NPCs.ini", "forestmonster", "scale", 0.0) / 20.0)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            meshcullbox(arg0\Field0, ((- meshwidth(arg0\Field0)) * 2.0), ((- meshheight(arg0\Field0)) * 2.0), ((- meshdepth(arg0\Field0)) * 2.0), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 4.0), (meshdepth(arg0\Field0) * 4.0))
            arg0\Field68 = 0.25
        Case $0F
            local9 = $00
            For local7 = Each npcs
                If (((arg0\Field5 = local7\Field5) And (arg0 <> local7)) <> 0) Then
                    local9 = (local9 + $01)
                EndIf
            Next
            If (local9 = $00) Then
                local3 = $35
            EndIf
            If (local9 = $01) Then
                local3 = $59
            EndIf
            If (local9 = $02) Then
                local3 = $60
            EndIf
            arg0\Field43 = ("SCP-939-" + (Str local3))
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.3, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(obj939, $00)
            nameentityex(arg0, "939")
            local1 = (getinifloat("DATA\NPCs.ini", "SCP-939", "scale", 0.0) / 2.5)
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = (getinifloat("DATA\NPCs.ini", "SCP-939", "speed", 0.0) / 100.0)
            arg0\Field68 = 0.3
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
            local3 = $01
            For local7 = Each npcs
                If (((arg0\Field5 = local7\Field5) And (arg0 <> local7)) <> 0) Then
                    local3 = (local3 + $01)
                EndIf
            Next
            arg0\Field43 = ("SCP-966-" + (Str local3))
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.2, 0.0)
            arg0\Field0 = copyentity(npc966obj, $00)
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
            For local7 = Each npcs
                If (((arg0\Field5 = local7\Field5) And (arg0 <> local7)) <> 0) Then
                    arg0\Field0 = copyentity(local7\Field0, $00)
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
            arg0\Field0 = copyentity(surgeon_zombie, $00)
            nameentityex(arg0, "008")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(arg0\Field0)), (- meshheight(arg0\Field0)), (- meshdepth(arg0\Field0)), (meshwidth(arg0\Field0) * 2.0), (meshheight(arg0\Field0) * 2.0), (meshdepth(arg0\Field0) * 2.0))
            setnpcframe(arg0, 11.0)
            arg0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            arg0\Field59 = $78
            entitypickmode(arg0\Field0, $02, $01)
        Case $16
            arg0\Field43 = "Human"
            arg0\Field4 = createpivot($00)
            entityradius(arg0\Field4, 0.32, 0.0)
            entitytype(arg0\Field4, $02, $00)
            arg0\Field0 = copyentity(clerkobj, $00)
            nameentityex(arg0, "clerk")
            local1 = (0.5 / meshwidth(arg0\Field0))
            scaleentity(arg0\Field0, local1, local1, local1, $00)
            arg0\Field21 = 0.02
            meshcullbox(arg0\Field0, (- meshwidth(clerkobj)), (- meshheight(clerkobj)), (- meshdepth(clerkobj)), (meshwidth(clerkobj) * 2.0), (meshheight(clerkobj) * 2.0), (meshdepth(clerkobj) * 2.0))
            arg0\Field68 = 0.32
    End Select
    Return $00
End Function
