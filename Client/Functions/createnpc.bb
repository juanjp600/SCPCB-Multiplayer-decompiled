Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1.npcs
    Local local2#
    Local local3%
    Local local4%
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11%
    catcherrors(((((((("CreateNPC(" + (Str arg0)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)))
    local0 = (New npcs)
    local0\Field4 = arg0
    local0\Field48 = 1.0
    local0\Field49 = 0.2
    local0\Field6 = 0.2
    local0\Field9 = 10.0
    local0\Field64 = $01
    Select arg0
        Case $00
            local0\Field47 = getlocalstring("npc", "human")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-008-1", "Speed", 0.0, $01) / 100.0)
            local0\Field60 = $64
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$00], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-008-1", "Scale", 0.0, $01) / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            setnpcframe(local0, 11.0, $01)
            If (npcsound[$03] = $00) Then
                npcsound[$03] = loadsound_strict("SFX\SCP\008_1\Breath.ogg")
            EndIf
        Case $01
            local0\Field47 = getlocalstring("npc", "undefine")
            local0\Field49 = 0.0
            local0\Field60 = $1F4
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$01], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-035's Tentacle", "Scale", 0.0, $01) / 10.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            setnpcframe(local0, 282.0, $01)
            If (npcsound[$04] = $00) Then
                npcsound[$04] = loadsound_strict("SFX\SCP\035_Tentacle\TentacleIdle.ogg")
            EndIf
        Case $02
            local0\Field47 = "SCP-049"
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-049", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$02], $00)
            local2 = inigetfloat("Data\NPCs.ini", "SCP-049", "Scale", 0.0, $01)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            If (npcsound[$05] = $00) Then
                npcsound[$05] = loadsound_strict("SFX\SCP\049\Breath.ogg")
            EndIf
        Case $03
            local0\Field47 = getlocalstring("npc", "human")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-049-2", "Speed", 0.0, $01) / 100.0)
            local0\Field60 = $96
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$03], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-049-2", "Scale", 0.0, $01) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            If (npcsound[$06] = $00) Then
                npcsound[$06] = loadsound_strict("SFX\SCP\049_2\Breath.ogg")
            EndIf
            If (npcsound[$07] = $00) Then
                npcsound[$07] = loadsound_strict("SFX\SCP\049_2\Resting.ogg")
            EndIf
        Case $04
            local0\Field47 = "SCP-066"
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-066", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$04], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-066", "Scale", 0.0, $01) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $05
            local0\Field47 = "SCP-096"
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-096", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.23
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$05], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-096", "Scale", 0.0, $01) / 3.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, ((- meshwidth(local0\Field0)) * 2.0), ((- meshheight(local0\Field0)) * 2.0), ((- meshdepth(local0\Field0)) * 2.0), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 4.0), (meshdepth(local0\Field0) * 4.0))
            local0\Field1 = createsprite(findchild(local0\Field0, "Reyelid"))
            scalesprite(local0\Field1, 0.07, 0.08)
            entityorder(local0\Field1, $FFFFFFFB)
            entitytexture(local0\Field1, t\Field2[$02], $00, $00)
            hideentity(local0\Field1)
        Case $06
            local0\Field47 = "SCP-106"
            local0\Field48 = 0.0
            local0\Field49 = 0.0
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-106", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$06], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-106", "Scale", 0.0, $01) / 2.2)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            local4 = loadtexture_strict("GFX\NPCs\scp_106_eyes.png", $01, $00, $00)
            entitytexture(local0\Field1, local4, $00, $00)
            deletesingletextureentryfromcache(local4, $00)
            local4 = $00
            entityblend(local0\Field1, $03)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
            hideentity(local0\Field1)
        Case $07
            local0\Field47 = "SCP-173"
            local0\Field64 = $00
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-173", "Speed", 0.0, $01) / 100.0)
            local0\Field8 = $01
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.32
            entityradius(local0\Field3, (local0\Field6 - 0.09), local0\Field6)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$07], $00)
            local0\Field1 = copyentity(n_i\Field0[$08], $00)
            Select left(currentdate(), $07)
                Case "31 Oct "
                    n_i\Field10 = $01
                    local4 = loadtexture_strict("GFX\NPCs\scp_173_H.png", $01, $00, $01)
                Case "01 Jan "
                    n_i\Field11 = $01
                    local4 = loadtexture_strict("GFX\NPCs\scp_173_NY.png", $01, $00, $01)
                Case "01 Apr "
                    n_i\Field12 = $01
                    local4 = loadtexture_strict("GFX\NPCs\scp_173_J.png", $01, $00, $01)
            End Select
            If (local4 <> $00) Then
                entitytexture(local0\Field0, local4, $00, $00)
                entitytexture(local0\Field1, local4, $00, $00)
                deletesingletextureentryfromcache(local4, $00)
                local4 = $00
            EndIf
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-173", "Scale", 0.0, $01) / meshdepth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            scaleentity(local0\Field1, local2, local2, local2, $00)
            local0\Field2 = copyentity(n_i\Field0[$09], $00)
            scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            hideentity(local0\Field2)
        Case $08
            local0\Field47 = "SCP-372"
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            local0\Field0 = copyentity(n_i\Field0[$0E], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-372", "Scale", 0.0, $01) / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            hideentity(local0\Field0)
        Case $09
            local0\Field47 = "SCP-513-1"
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            local0\Field0 = copyentity(n_i\Field0[$0F], $00)
            hideentity(local0\Field0)
            local0\Field1 = copyentity(local0\Field0, $00)
            entityalpha(local0\Field1, 0.6)
            hideentity(local0\Field1)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-513-1", "Scale", 0.0, $01) / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            scaleentity(local0\Field1, local2, local2, local2, $00)
        Case $11
            local0\Field47 = getlocalstring("npc", "apache")
            local0\Field48 = 0.0
            local0\Field49 = 0.0
            local0\Field3 = createpivot($00)
            local0\Field6 = 3.0
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $04, $00)
            local0\Field0 = copyentity(n_i\Field0[$17], $00)
            local0\Field1 = copyentity(n_i\Field0[$18], $00)
            entityparent(local0\Field1, local0\Field0, $01)
            For local3 = $FFFFFFFF To $01 Step $02
                local7 = copyentity(local0\Field1, local0\Field1)
                rotateentity(local7, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local7, 0.5)
            Next
            local0\Field2 = copyentity(n_i\Field0[$19], $00)
            entityparent(local0\Field2, local0\Field0, $01)
            positionentity(local0\Field2, 0.0, 2.15, -5.48, $00)
            For local3 = $FFFFFFFF To $01 Step $02
                local8 = createlight($02, local0\Field0)
                lightrange(local8, 2.0)
                lightcolor(local8, 255.0, 255.0, 255.0)
                positionentity(local8, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local9 = createsprite(local0\Field0)
                positionentity(local9, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local9, 0.13, 0.13)
                entitytexture(local9, misc_i\Field2[$00], $00, $00)
                entityblend(local9, $03)
                entityfx(local9, $09)
            Next
            scaleentity(local0\Field0, 0.7, 0.7, 0.7, $00)
        Case $13,$12
            local10 = "Class D"
            local11 = $1B
            If (local0\Field4 = $12) Then
                local10 = "Clerk"
                local11 = $1A
            EndIf
            local0\Field47 = getlocalstring("npc", "human")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", local10, "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[local11], $00)
            local2 = (inigetfloat("Data\NPCs.ini", local10, "Scale", 0.0, $01) / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
        Case $14
            local0\Field47 = getlocalstring("npc", "human")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "Guard", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$1D], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "Guard", "Scale", 0.0, $01) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
        Case $15
            local0\Field47 = getlocalstring("npc", "human")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "MTF", "Speed", 0.0, $01) / 100.0)
            local0\Field60 = $64
            local0\Field49 = 0.03
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$1E], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "MTF", "Scale", 0.0, $01) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            If (npcsound[$00] = $00) Then
                npcsound[$00] = loadsound_strict("SFX\Character\MTF\Beep.ogg")
            EndIf
            If (npcsound[$01] = $00) Then
                npcsound[$01] = loadsound_strict("SFX\Character\MTF\Breath.ogg")
            EndIf
        Case $0A
            local0\Field47 = getlocalstring("npc", "undefine")
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-860-2", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.25
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$10], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-860-2", "Scale", 0.0, $01) / 20.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, ((- meshwidth(local0\Field0)) * 2.0), ((- meshheight(local0\Field0)) * 2.0), ((- meshdepth(local0\Field0)) * 2.0), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 4.0), (meshdepth(local0\Field0) * 4.0))
            entityfx(local0\Field0, $01)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.1, 0.1)
            local4 = loadtexture_strict("GFX\NPCs\scp_860_2_eyes.png", $03, $00, $00)
            entitytexture(local0\Field1, local4, $00, $00)
            deletesingletextureentryfromcache(local4, $00)
            local4 = $00
            entityfx(local0\Field1, $09)
            entityblend(local0\Field1, $03)
            spriteviewmode(local0\Field1, $02)
            hideentity(local0\Field1)
            If (forestnpc = $00) Then
                forestnpc = createsprite($00)
                scalesprite(forestnpc, (1.0 / 3.904762), 0.75)
                spriteviewmode(forestnpc, $04)
                entityfx(forestnpc, $09)
                forestnpctex = loadanimtexture_strict("GFX\NPCs\AgentIJ.AIJ", $03, $8C, $19A, $00, $04, $01)
                forestnpcdata[$00] = 0.0
                entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                forestnpcdata[$01] = 0.0
                forestnpcdata[$02] = 0.0
                hideentity(forestnpc)
            EndIf
        Case $0B
            local3 = $01
            For local1 = Each npcs
                If (local0 <> local1) Then
                    If (local0\Field4 = local1\Field4) Then
                        local3 = (local3 + $01)
                    EndIf
                EndIf
            Next
            local0\Field47 = ("SCP-939-" + (Str local3))
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-939", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.32
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$11], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-939", "Scale", 0.0, $01) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $0C
            local3 = $01
            For local1 = Each npcs
                If (local0 <> local1) Then
                    If (local0\Field4 = local1\Field4) Then
                        local3 = (local3 + $01)
                    EndIf
                EndIf
            Next
            local0\Field47 = ("SCP-966-" + (Str local3))
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-966", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$12], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-966", "Scale", 0.0, $01) / 40.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            setnpcframe(local0, 15.0, $01)
        Case $0D
            local0\Field47 = "SCP-999"
            local0\Field23 = (inigetfloat("Data\NPCs.ini", "SCP-999", "Speed", 0.0, $01) / 100.0)
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.15
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$13], $00)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-999", "Scale", 0.0, $01) / 100.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $0E
            local0\Field47 = "SCP-1048"
            local0\Field48 = 0.0
            local0\Field49 = 0.0
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$14], $00)
            entitypickmode(local0\Field0, $02, $01)
            local2 = (inigetfloat("Data\NPCs.ini", "SCP-1048", "Scale", 0.0, $01) / 10.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $0F
            local0\Field47 = getlocalstring("npc", "undefine")
            local0\Field23 = inigetfloat("Data\NPCs.ini", "SCP-1048", "Speed", 0.0, $01)
            local0\Field60 = $3C
            local0\Field3 = createpivot($00)
            local0\Field6 = 0.1
            entityradius(local0\Field3, local0\Field6, 0.15)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$15], $00)
            local0\Field61 = ((inigetfloat("Data\NPCs.ini", "SCP-1048", "Scale", 0.0, $01) / 10.0) * rnd(0.9, 1.1))
            scaleentity(local0\Field0, local0\Field61, local0\Field61, local0\Field61, $00)
        Case $10
            local0\Field47 = getlocalstring("npc", "undefine")
            local0\Field23 = ((inigetfloat("Data\NPCs.ini", "SCP-1499-1", "Speed", 0.0, $01) / 100.0) * rnd(0.9, 1.1))
            local0\Field3 = createpivot($00)
            entityradius(local0\Field3, local0\Field6, 0.0)
            entitytype(local0\Field3, $02, $00)
            local0\Field0 = copyentity(n_i\Field0[$16], $00)
            local0\Field61 = ((inigetfloat("Data\NPCs.ini", "SCP-1499-1", "Scale", 0.0, $01) / 4.0) * rnd(0.8, 1.0))
            scaleentity(local0\Field0, local0\Field61, local0\Field61, local0\Field61, $00)
            entityfx(local0\Field0, $01)
            entityautofade(local0\Field0, (hidedistance * 2.5), (hidedistance * 2.95))
    End Select
    positionentity(local0\Field3, arg1, arg2, arg3, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    resetentity(local0\Field3)
    mp_initializenpc(local0, $FFFFFFFF)
    npcspeedchange(local0)
    catcherrors(((((((("Uncaught: CreateNPC(" + (Str arg0)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)))
    Return local0
    Return Null
End Function
