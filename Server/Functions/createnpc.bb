Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1.npcs
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    local0 = (New npcs)
    local0\Field5 = arg0
    local0\Field44 = 1.0
    local0\Field45 = 0.2
    local0\Field68 = 0.2
    local0\Field72 = 10.0
    local0\Field67 = $00
    local0\Field76 = 700.0
    Select arg0
        Case $01
            local0\Field43 = "SCP-173"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.23, 0.32)
            entitytype(local0\Field4, $02, $00)
            local0\Field8 = $01
            local0\Field0 = copyentity(object_173, $00)
            If (left(currentdate(), $07) = "31 Oct ") Then
                local11 = $01
                local12 = loadtexture_strict("GFX\npcs\173h.pt", $01)
                entitytexture(local0\Field0, local12, $00, $00)
                freetexture(local12)
            EndIf
            local2 = (getinifloat("Data\NPCs.ini", "SCP-173", "scale", 0.0) / meshdepth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            nameentityex(local0, "173")
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-173", "speed", 0.0) / 100.0)
            local0\Field1 = loadmesh_strict("GFX\173box.b3d", $00)
            scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
            hideentity(local0\Field1)
            local0\Field68 = 0.32
            curr173 = local0
        Case $02
            local0\Field43 = "SCP-106"
            local0\Field4 = createpivot($00)
            local0\Field44 = 0.0
            local0\Field45 = 0.0
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(npc106obj, $00)
            nameentityex(local0, "106")
            local2 = (getinifloat("Data\NPCs.ini", "SCP-106", "scale", 0.0) / 2.2)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local13 = loadtexture_strict("GFX\npcs\oldmaneyes.jpg", $01)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-106", "speed", 0.0) / 100.0)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            entitytexture(local0\Field1, local13, $00, $00)
            entityblend(local0\Field1, $03)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
            freetexture(local13)
            curr106 = local0
        Case $03
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(guardobj, $00)
            nameentityex(local0, "guard")
            local0\Field21 = (getinifloat("Data\NPCs.ini", "Guard", "speed", 0.0) / 100.0)
            local2 = (getinifloat("Data\NPCs.ini", "Guard", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $08
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(mtfobj, $00)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "MTF", "speed", 0.0) / 100.0)
            local2 = (getinifloat("Data\NPCs.ini", "MTF", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            nameentityex(local0, "mtf")
            If (mtfsfx($00) = $00) Then
                mtfsfx($00) = loadsound_strict("SFX\Character\MTF\ClassD1.ogg")
                mtfsfx($01) = loadsound_strict("SFX\Character\MTF\ClassD2.ogg")
                mtfsfx($02) = loadsound_strict("SFX\Character\MTF\ClassD3.ogg")
                mtfsfx($03) = loadsound_strict("SFX\Character\MTF\ClassD4.ogg")
                mtfsfx($05) = loadsound_strict("SFX\Character\MTF\Beep.ogg")
                mtfsfx($06) = loadsound_strict("SFX\Character\MTF\Breath.ogg")
            EndIf
        Case $04
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(classdobj, $00)
            nameentityex(local0, "classd")
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            local0\Field68 = 0.32
        Case $17
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(classdobj, $00)
            nameentityex(local0, "classd")
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            local0\Field68 = 0.32
        Case $06
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh_strict("GFX\npcs\372.b3d", $00)
            nameentityex(local0, "372")
            local2 = (0.35 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $0C
            local0\Field43 = "SCP-513-1"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh_strict("GFX\npcs\bll.b3d", $00)
            nameentityex(local0, "5131")
            local0\Field1 = copyentity(local0\Field0, $00)
            entityalpha(local0\Field1, 0.6)
            local2 = (1.8 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            scaleentity(local0\Field1, local2, local2, local2, $00)
            curr5131 = local0
        Case $09
            local0\Field43 = "SCP-096"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.26, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(object_096, $00)
            nameentityex(local0, "096")
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-096", "speed", 0.0) / 100.0)
            local2 = (getinifloat("Data\NPCs.ini", "SCP-096", "scale", 0.0) / 3.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field68 = 0.26
            curr096 = local0
        Case $0A
            local0\Field43 = "SCP-049"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(npc049obj, $00)
            nameentityex(local0, "049")
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-049", "speed", 0.0) / 100.0)
            local2 = getinifloat("Data\NPCs.ini", "SCP-049", "scale", 0.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field16 = loadsound_strict("SFX\Horror\Horror12.ogg")
            If (horrorsfx($0D) = $00) Then
                horrorsfx($0D) = loadsound_strict("SFX\Horror\Horror13.ogg")
            EndIf
        Case $0B
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(npc0492obj, $00)
            nameentityex(local0, "zombie")
            local2 = (getinifloat("Data\NPCs.ini", "SCP-049-2", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-049-2", "speed", 0.0) / 100.0)
            setanimtime(local0\Field0, 107.0, $00)
            local0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            local0\Field59 = $64
            entitypickmode(local0\Field0, $02, $01)
        Case $07
            local0\Field43 = "Human"
            local0\Field44 = 0.0
            local0\Field45 = 0.0
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = copyentity(apacheobj, $00)
            local0\Field1 = copyentity(apacherotorobj, $00)
            entityparent(local0\Field1, local0\Field0, $01)
            nameentityex(local0, "apache")
            For local3 = $FFFFFFFF To $01 Step $02
                local14 = copyentity(local0\Field1, local0\Field1)
                rotateentity(local14, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local14, 0.5)
            Next
            local0\Field2 = loadanimmesh_strict("GFX\apacherotor2.b3d", local0\Field0)
            positionentity(local0\Field2, 0.0, 2.15, -5.48, $00)
            entitytype(local0\Field4, $04, $00)
            entityradius(local0\Field4, 3.0, 0.0)
            For local3 = $FFFFFFFF To $01 Step $02
                local15 = createlight($02, local0\Field0)
                lightrange(local15, 2.0)
                lightcolor(local15, 255.0, 255.0, 255.0)
                positionentity(local15, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local16 = createsprite(local0\Field0)
                positionentity(local16, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local16, 0.13, 0.13)
                entitytexture(local16, lightspritetex($00), $00, $00)
                entityblend(local16, $03)
                entityfx(local16, $09)
            Next
            local2 = 0.6
            scaleentity(local0\Field0, local2, local2, local2, $00)
            entitypickmode(local0\Field0, $02, $01)
        Case $0D
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = loadanimmesh_strict("GFX\NPCs\035tentacle.b3d", $00)
                scaleentity(local0\Field0, 0.065, 0.065, 0.065, $00)
            EndIf
            nameentityex(local0, "tent")
            setanimtime(local0\Field0, 283.0, $00)
        Case $0E
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.25, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh_strict("GFX\npcs\forestmonster.b3d", $00)
            entityfx(local0\Field0, $01)
            local17 = loadtexture_strict("GFX\npcs\860_eyes.png", $03)
            nameentityex(local0, "860")
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.1, 0.1)
            entitytexture(local0\Field1, local17, $00, $00)
            freetexture(local17)
            entityfx(local0\Field1, $09)
            entityblend(local0\Field1, local18)
            spriteviewmode(local0\Field1, $02)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "forestmonster", "speed", 0.0) / 100.0)
            local2 = (getinifloat("Data\NPCs.ini", "forestmonster", "scale", 0.0) / 20.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field68 = 0.25
        Case $0F
            local19 = $00
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local19 = (local19 + $01)
                EndIf
            Next
            If (local19 = $00) Then
                local3 = $35
            EndIf
            If (local19 = $01) Then
                local3 = $59
            EndIf
            If (local19 = $02) Then
                local3 = $60
            EndIf
            local0\Field43 = ("SCP-939-" + (Str local3))
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.3, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(obj939, $00)
            nameentityex(local0, "939")
            local2 = (getinifloat("Data\NPCs.ini", "SCP-939", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-939", "speed", 0.0) / 100.0)
            local0\Field68 = 0.3
        Case $10
            local0\Field43 = "SCP-066"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh_strict("GFX\NPCs\scp-066.b3d", $00)
            local2 = (getinifloat("Data\NPCs.ini", "SCP-066", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            nameentityex(local0, "066")
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-066", "speed", 0.0) / 100.0)
        Case $12
            local3 = $01
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local3 = (local3 + $01)
                EndIf
            Next
            local0\Field43 = ("SCP-966-" + (Str local3))
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = copyentity(npc966obj, $00)
            entityfx(local0\Field0, $01)
            local2 = (getinifloat("Data\NPCs.ini", "SCP-966", "scale", 0.0) / 40.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            nameentityex(local0, "966")
            setanimtime(local0\Field0, 15.0, $00)
            entitytype(local0\Field4, $02, $00)
            local0\Field21 = (getinifloat("Data\NPCs.ini", "SCP-966", "speed", 0.0) / 100.0)
        Case $13
            local0\Field43 = "SCP-1048-A"
            local0\Field0 = loadanimmesh_strict("GFX\npcs\scp-1048a.b3d", $00)
            scaleentity(local0\Field0, 0.05, 0.05, 0.05, $00)
            setanimtime(local0\Field0, 2.0, $00)
            local0\Field16 = loadsound_strict("SFX\SCP\1048A\Shriek.ogg")
            local0\Field19 = loadsound_strict("SFX\SCP\1048A\Growth.ogg")
            nameentityex(local0, "1048")
        Case $14
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = loadanimmesh_strict("GFX\npcs\1499-1.b3d", $00)
            EndIf
            nameentityex(local0, "1499")
            local0\Field21 = ((getinifloat("Data\NPCs.ini", "SCP-1499-1", "speed", 0.0) / 100.0) * rnd(0.9, 1.1))
            local2 = ((getinifloat("Data\NPCs.ini", "SCP-1499-1", "scale", 0.0) / 4.0) * rnd(0.8, 1.0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            entityfx(local0\Field0, $01)
            entityautofade(local0\Field0, (hidedistance * 2.5), (hidedistance * 2.95))
        Case $15
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(surgeon_zombie, $00)
            nameentityex(local0, "008")
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            setnpcframe(local0, 11.0)
            local0\Field16 = loadsound_strict("SFX\SCP\049\0492Breath.ogg")
            local0\Field59 = $78
            entitypickmode(local0\Field0, $02, $01)
        Case $16
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(clerkobj, $00)
            nameentityex(local0, "clerk")
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            local0\Field68 = 0.32
    End Select
    If (arg0 <> $17) Then
        positionentity(local0\Field4, arg1, arg2, arg3, $01)
        positionentity(local0\Field0, arg1, arg2, arg3, $01)
        resetentity(local0\Field4)
    EndIf
    local0\Field6 = $00
    local0\Field6 = findfreenpcid()
    m_npc[local0\Field6] = local0
    debuglog((((((("Created NPC " + local0\Field43) + " (ID: ") + (Str local0\Field6)) + ")") + " Type = ") + (Str local0\Field5)))
    npcspeedchange(local0)
    local20 = (local20 + $01)
    If (getscripts() <> 0) Then
        public_inqueue($3D, $00)
        public_addparam($00, (Str local0\Field6), $01)
        callback($00)
    EndIf
    Return local0
    Return Null
End Function
