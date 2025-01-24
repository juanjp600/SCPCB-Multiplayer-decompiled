Function loadgame%(arg0$)
    Local local0.rooms
    Local local1.npcs
    Local local2.doors
    Local local3.emitter
    Local local4.roomtemplates
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12$
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17#
    Local local18#
    Local local19$
    Local local20%
    Local local22.npcs
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28#
    Local local29#
    Local local30#
    Local local31%
    Local local32%
    Local local35%
    Local local36%
    Local local37%
    Local local38#
    Local local39%
    Local local40%
    Local local41#
    Local local42#
    Local local43#
    Local local44#
    Local local45#
    Local local46#
    Local local47#
    Local local48%
    Local local49%
    Local local50%
    Local local53.decals
    Local local54#
    Local local55#
    Local local56#
    Local local57#
    Local local58#
    Local local59#
    Local local60%
    Local local61%
    Local local62%
    Local local63%
    Local local64%
    Local local65#
    Local local66#
    Local local67#
    Local local68#
    Local local69.events
    Local local70.chunk
    Local local71.chunkpart
    Local local73.dummy1499_1
    Local local74.items
    Local local75$
    Local local76$
    Local local77$
    Local local78%
    Local local79.itemtemplates
    Local local80%
    Local local81.items
    Local local82.rooms
    catcherrors((("LoadGame(" + arg0) + ")"))
    local10 = $00
    local11 = $00
    local12 = ""
    local15 = readfile_strict((("Saves\" + arg0) + "\save.cb"))
    me\Field36 = 0.0
    gamesaved = $01
    readstring(local15)
    readstring(local15)
    local12 = readstring(local15)
    If (local12 <> "1.5") Then
        runtimeerrorex(format(format(getlocalstring("save", "imcompatible"), local12, "{0}"), "1.5", "{1}"))
    EndIf
    readbyte(local15)
    readstring(local15)
    readstring(local15)
    code_dr_maynard = readint(local15)
    code_o5_council = readint(local15)
    code_maintenance_tunnels = readint(local15)
    code_dr_gears = readint(local15)
    local5 = readfloat(local15)
    local6 = readfloat(local15)
    local7 = readfloat(local15)
    positionentity(me\Field60, local5, (local6 + 0.3), local7, $00)
    resetentity(me\Field60)
    showentity(me\Field60)
    local5 = readfloat(local15)
    local6 = readfloat(local15)
    local7 = readfloat(local15)
    positionentity(me\Field61, local5, (local6 + 0.3), local7, $00)
    resetentity(me\Field61)
    local5 = readfloat(local15)
    local6 = readfloat(local15)
    rotateentity(me\Field60, local5, local6, 0.0, $00)
    me\Field10 = readfloat(local15)
    me\Field11 = readfloat(local15)
    me\Field12 = readfloat(local15)
    me\Field13 = readfloat(local15)
    me\Field49 = readfloat(local15)
    me\Field35 = readfloat(local15)
    me\Field39 = readbyte(local15)
    me\Field17 = readfloat(local15)
    me\Field18 = readfloat(local15)
    me\Field19 = readfloat(local15)
    me\Field15 = readfloat(local15)
    me\Field14 = readfloat(local15)
    me\Field31 = readfloat(local15)
    me\Field32 = readfloat(local15)
    me\Field33 = readfloat(local15)
    me\Field34 = readfloat(local15)
    msg\Field2 = readstring(local15)
    me\Field63 = readint(local15)
    me\Field64 = readbyte(local15)
    me\Field26 = readfloat(local15)
    me\Field25 = readbyte(local15)
    me\Field21 = readfloat(local15)
    me\Field23 = readfloat(local15)
    me\Field24 = readfloat(local15)
    me\Field50 = readfloat(local15)
    me\Field51 = readfloat(local15)
    me\Field5 = readfloat(local15)
    me\Field53 = readint(local15)
    i_005\Field0 = readbyte(local15)
    i_500\Field0 = readbyte(local15)
    For local8 = $00 To $06 Step $01
        i_1025\Field0[local8] = readfloat(local15)
    Next
    For local8 = $00 To $04 Step $01
        i_1025\Field1[local8] = readfloat(local15)
    Next
    i_008\Field0 = readfloat(local15)
    i_008\Field1 = readbyte(local15)
    i_409\Field0 = readfloat(local15)
    i_409\Field1 = readbyte(local15)
    i_035\Field0 = readbyte(local15)
    local16 = readbyte(local15)
    selecteddifficulty = difficulties[local16]
    If (local16 = $04) Then
        selecteddifficulty\Field2 = readbyte(local15)
        selecteddifficulty\Field3 = readbyte(local15)
        selecteddifficulty\Field4 = readbyte(local15)
        selecteddifficulty\Field9 = readbyte(local15)
    EndIf
    maxitemamount = (selecteddifficulty\Field9 + ((0.0 < i_1025\Field1[$00]) Shl $01))
    Dim inventory.items((selecteddifficulty\Field9 + $02))
    wi\Field1 = readfloat(local15)
    wi\Field0 = readbyte(local15)
    wi\Field3 = readbyte(local15)
    wi\Field4 = readbyte(local15)
    wi\Field2 = readbyte(local15)
    wi\Field5 = readbyte(local15)
    wi\Field9 = readbyte(local15)
    i_1499\Field0 = readbyte(local15)
    i_1499\Field1 = readfloat(local15)
    i_1499\Field2 = readfloat(local15)
    i_1499\Field3 = readfloat(local15)
    i_1499\Field5 = readfloat(local15)
    i_1499\Field6 = readfloat(local15)
    i_1499\Field7 = readfloat(local15)
    local17 = readfloat(local15)
    local18 = readfloat(local15)
    i_966\Field1 = readfloat(local15)
    i_966\Field0 = readfloat(local15)
    i_1048a\Field0 = readfloat(local15)
    i_1048a\Field1 = readbyte(local15)
    i_268\Field0 = readbyte(local15)
    i_268\Field1 = readfloat(local15)
    i_427\Field0 = readbyte(local15)
    i_427\Field1 = readfloat(local15)
    i_714\Field0 = readbyte(local15)
    i_294\Field0 = readbyte(local15)
    randomseed = readstring(local15)
    secondarylighton = readfloat(local15)
    lightvolume = readfloat(local15)
    isblackout = readbyte(local15)
    previsblackout = readbyte(local15)
    remotedooron = readbyte(local15)
    soundtransmission = readbyte(local15)
    key2_spawnrate = readbyte(local15)
    Repeat
        local19 = readstring(local15)
        If (local19 = "EOA") Then
            Exit
        EndIf
        s2imapset(unlockedachievements, local19, $01)
    Forever
    usedconsole = readbyte(local15)
    mtftimer = readfloat(local15)
    remove714timer = readfloat(local15)
    removehazmattimer = readfloat(local15)
    currmapgrid = (New mapgrid)
    For local5 = 0.0 To 21.0 Step 1.0
        For local6 = 0.0 To 21.0 Step 1.0
            currmapgrid\Field0[(Int ((local6 * 21.0) + local5))] = readbyte(local15)
            currmapgrid\Field2[(Int ((local6 * 21.0) + local5))] = readbyte(local15)
        Next
    Next
    If (readint(local15) <> $71) Then
        runtimeerrorex(getlocalstring("save", "corrupted_1"))
    EndIf
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local20 = readbyte(local15)
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local1 = createnpc(local20, local5, local6, local7)
        Select local20
            Case $07
                n_i\Field2 = local1
            Case $06
                n_i\Field3 = local1
            Case $05
                n_i\Field4 = local1
            Case $09
                n_i\Field5 = local1
            Case $02
                n_i\Field6 = local1
            Case $04
                n_i\Field7 = local1
        End Select
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        rotateentity(local1\Field3, local5, local6, local7, $00)
        local1\Field10 = readfloat(local15)
        local1\Field11 = readfloat(local15)
        local1\Field12 = readfloat(local15)
        local1\Field13 = readint(local15)
        local1\Field26 = (Float readbyte(local15))
        local1\Field30 = readfloat(local15)
        local1\Field29 = readint(local15)
        local1\Field24 = readfloat(local15)
        local1\Field15 = readfloat(local15)
        local1\Field28 = readfloat(local15)
        forcesetnpcid(local1, readint(local15))
        local1\Field35 = readint(local15)
        local1\Field36 = readfloat(local15)
        local1\Field37 = readfloat(local15)
        local1\Field38 = readfloat(local15)
        local1\Field25 = readstring(local15)
        If (local1\Field25 <> "") Then
            local13 = loadtexture_strict(local1\Field25, $01, $00, $01)
            entitytexture(local1\Field0, local13, $00, $00)
            deletesingletextureentryfromcache(local13, $00)
            local13 = $00
        EndIf
        local1\Field63 = readbyte(local15)
        If (local1\Field63 <> 0) Then
            createnpcasset(local1)
        EndIf
        local1\Field64 = readbyte(local15)
        If (local1\Field64 <> 0) Then
            local1\Field14 = readfloat(local15)
            setanimtime(local1\Field0, local1\Field14, $00)
        EndIf
        local1\Field65 = readbyte(local15)
        local1\Field50 = readbyte(local15)
        local1\Field60 = readint(local15)
        local1\Field61 = readfloat(local15)
        If (0.0 < local1\Field61) Then
            scaleentity(local1\Field0, local1\Field61, local1\Field61, local1\Field61, $00)
        EndIf
        changenpctextureid(local1, (readbyte(local15) - $01))
        local1\Field43 = readbyte(local15)
    Next
    For local1 = Each npcs
        If (local1\Field35 <> $00) Then
            For local22 = Each npcs
                If (local22 <> local1) Then
                    If (local22\Field5 = local1\Field35) Then
                        local1\Field34 = local22
                    EndIf
                EndIf
            Next
        EndIf
    Next
    If (readint(local15) <> $278) Then
        runtimeerrorex(getlocalstring("save", "corrupted_2"))
    EndIf
    i_zone\Field0[$00] = readbyte(local15)
    i_zone\Field0[$01] = readbyte(local15)
    i_zone\Field1 = readbyte(local15)
    i_zone\Field2 = readbyte(local15)
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local23 = readint(local15)
        local24 = readint(local15)
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local25 = readbyte(local15)
        local26 = readint(local15)
        local11 = readbyte(local15)
        local24 = (Int wrapangle((Float local24), 360.0))
        For local4 = Each roomtemplates
            If (local4\Field1 = local23) Then
                local0 = createroom(local26, local4\Field4, local5, local6, local7, local4\Field6, (Float local24))
                calculateroomextents(local0)
                local0\Field1 = local25
                Exit
            EndIf
        Next
        If (local11 = $01) Then
            playerroom = local0
        EndIf
        For local9 = $00 To $0B Step $01
            local14 = readint(local15)
            If (local14 > $00) Then
                For local1 = Each npcs
                    If (local1\Field5 = local14) Then
                        local0\Field15[local9] = local1
                        Exit
                    EndIf
                Next
            EndIf
        Next
        For local9 = $00 To $03 Step $01
            local14 = readbyte(local15)
            If (local14 = $00) Then
                rotateentity(local0\Field13[local9]\Field0, 80.0, entityyaw(local0\Field13[local9]\Field0, $00), 0.0, $00)
            ElseIf (local14 = $01) Then
                rotateentity(local0\Field13[local9]\Field0, -80.0, entityyaw(local0\Field13[local9]\Field0, $00), 0.0, $00)
            EndIf
        Next
        If (readbyte(local15) = $01) Then
            If (local0\Field18 <> Null) Then
                destroymt(local0\Field18, $01)
                Delete local0\Field18
            EndIf
            local0\Field18 = (New mtgrid)
            For local6 = 0.0 To 18.0 Step 1.0
                For local5 = 0.0 To 18.0 Step 1.0
                    local0\Field18\Field0[(Int ((local6 * 19.0) + local5))] = readbyte(local15)
                    local0\Field18\Field1[(Int ((local6 * 19.0) + local5))] = readbyte(local15)
                Next
            Next
        EndIf
        local27 = readbyte(local15)
        If (local27 > $00) Then
            If (local0\Field10 <> Null) Then
                destroyforest(local0\Field10, $01)
            Else
                local0\Field10 = (New forest)
            EndIf
            For local6 = 0.0 To 9.0 Step 1.0
                For local5 = 0.0 To 9.0 Step 1.0
                    local0\Field10\Field2[(Int ((local6 * 10.0) + local5))] = readbyte(local15)
                Next
            Next
            local28 = readfloat(local15)
            local29 = readfloat(local15)
            local30 = readfloat(local15)
            If (local27 = $01) Then
                placeforest(local0\Field10, local28, local29, local30, local0)
            Else
                placemapcreatorforest(local0\Field10, local28, local29, local30, local0)
            EndIf
        ElseIf (local0\Field10 <> Null) Then
            destroyforest(local0\Field10, $01)
            Delete local0\Field10
        EndIf
    Next
    For local0 = Each rooms
        If (((local17 = local0\Field3) And (local18 = local0\Field5)) <> 0) Then
            i_1499\Field4 = local0
            Exit
        EndIf
    Next
    If (readint(local15) <> $3BA) Then
        runtimeerrorex(getlocalstring("save", "corrupted_3"))
    EndIf
    For local3 = Each emitter
        freeemitter(local3, $01)
    Next
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local14 = readint(local15)
        local11 = readbyte(local15)
        local3 = setemitter(Null, local5, local6, local7, local14)
        local3\Field11 = local11
        forcesetemitterid(local3, readint(local15))
    Next
    For local0 = Each rooms
        For local9 = $00 To $07 Step $01
            local14 = readint(local15)
            If (local14 > $00) Then
                For local3 = Each emitter
                    If (local3\Field5 = local14) Then
                        local0\Field17[local9] = local3
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    bk\Field0 = readbyte(local15)
    bk\Field1 = readfloat(local15)
    bk\Field2 = readfloat(local15)
    local6 = 21.0
    While (0.0 <= local6)
        If (local6 < (Float (i_zone\Field0[$01] - (selectedcustommap = Null)))) Then
            local31 = $03
        ElseIf (((local6 >= (Float (i_zone\Field0[$01] - (selectedcustommap = Null)))) And (local6 < (Float (i_zone\Field0[$00] - (selectedcustommap = Null))))) <> 0) Then
            local31 = $02
        Else
            local31 = $01
        EndIf
        local5 = 21.0
        While (0.0 <= local5)
            If (currmapgrid\Field0[(Int ((local6 * 21.0) + local5))] > $00) Then
                For local0 = Each rooms
                    local0\Field6 = (Int wrapangle((Float local0\Field6), 360.0))
                    If (((local5 = (Float (Int (local0\Field3 / 8.0)))) And (local6 = (Float (Int (local0\Field5 / 8.0))))) <> 0) Then
                        Select local0\Field7\Field4
                            Case $00
                                local32 = (90.0 = (Float local0\Field6))
                            Case $01
                                local32 = ((90.0 = (Float local0\Field6)) Lor (270.0 = (Float local0\Field6)))
                            Case $02
                                local32 = ((0.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local32 = (((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6))) Lor (90.0 = (Float local0\Field6)))
                            Default
                                local32 = $01
                        End Select
                        If (local32 <> 0) Then
                            If (22.0 > (local5 + 1.0)) Then
                                If (currmapgrid\Field0[(Int ((local5 + 1.0) + (local6 * 21.0)))] > $00) Then
                                    local0\Field20[$00] = createdoor(local0, ((local5 * 8.0) + 4.0), 0.0, (local6 * 8.0), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local31 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Select local0\Field7\Field4
                            Case $00
                                local32 = (180.0 = (Float local0\Field6))
                            Case $01
                                local32 = ((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6)))
                            Case $02
                                local32 = ((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local32 = (((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6))) Lor (270.0 = (Float local0\Field6)))
                            Default
                                local32 = $01
                        End Select
                        If (local32 <> 0) Then
                            If (22.0 > (local6 + 1.0)) Then
                                If (currmapgrid\Field0[(Int (((local6 + 1.0) * 21.0) + local5))] > $00) Then
                                    local0\Field20[$03] = createdoor(local0, (local5 * 8.0), 0.0, ((local6 * 8.0) + 4.0), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local31 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local5 = (local5 + -1.0)
        Wend
        local6 = (local6 + -1.0)
    Wend
    local35 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
    local36 = loadtexture_strict("GFX\Map\Textures\containment_doors_Corrosive.png", $01, $00, $01)
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local37 = readbyte(local15)
        local38 = readfloat(local15)
        local39 = readbyte(local15)
        local40 = readbyte(local15)
        local41 = readfloat(local15)
        local42 = readfloat(local15)
        local43 = readfloat(local15)
        local44 = readfloat(local15)
        local45 = readfloat(local15)
        local46 = readfloat(local15)
        local47 = readfloat(local15)
        local48 = readbyte(local15)
        local49 = readbyte(local15)
        local50 = readbyte(local15)
        For local2 = Each doors
            If ((((local5 = entityx(local2\Field2, $01)) And (local6 = entityy(local2\Field2, $01))) And (local7 = entityz(local2\Field2, $01))) <> 0) Then
                local2\Field6 = local37
                local2\Field8 = local38
                local2\Field4 = local39
                local2\Field20 = local40
                local2\Field12 = (Int local46)
                local2\Field13 = local47
                local2\Field22 = local48
                local2\Field23 = local49
                local2\Field27 = local50
                positionentity(local2\Field0, local41, local6, local42, $01)
                If (local50 <> 0) Then
                    Select local2\Field10
                        Case $00,$06,$01
                            entitytexture(local2\Field0, local35, $00, $00)
                            entitytexture(local2\Field2, local35, $00, $00)
                        Case $02
                            entitytexture(local2\Field0, local36, $00, $00)
                            entitytexture(local2\Field2, local36, $00, $00)
                    End Select
                EndIf
                rotateentity(local2\Field0, 0.0, local43, 0.0, $01)
                If (local2\Field1 <> $00) Then
                    positionentity(local2\Field1, local44, local6, local45, $01)
                    If (local50 <> 0) Then
                        Select local2\Field10
                            Case $00,$06,$01
                                entitytexture(local2\Field1, local35, $00, $00)
                            Case $02
                                entitytexture(local2\Field1, local36, $00, $00)
                        End Select
                    EndIf
                EndIf
                Exit
            EndIf
        Next
    Next
    deletesingletextureentryfromcache(local35, $00)
    local35 = $00
    deletesingletextureentryfromcache(local36, $00)
    local36 = $00
    If (readint(local15) <> $735) Then
        runtimeerrorex(getlocalstring("save", "corrupted_4"))
    EndIf
    For local53 = Each decals
        removedecal(local53)
    Next
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local14 = readint(local15)
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local54 = readfloat(local15)
        local55 = readfloat(local15)
        local56 = readfloat(local15)
        local53 = createdecal(local14, local5, local6, local7, local54, local55, local56, 1.0, 1.0, $00, $01, $00, $00, $00)
        local57 = readfloat(local15)
        local58 = readfloat(local15)
        local59 = readfloat(local15)
        local60 = readbyte(local15)
        local61 = readbyte(local15)
        local62 = readbyte(local15)
        local63 = readbyte(local15)
        local64 = readbyte(local15)
        local65 = readfloat(local15)
        local66 = readfloat(local15)
        local67 = readfloat(local15)
        local68 = readfloat(local15)
        For local53 = Each decals
            If ((((local5 = entityx(local53\Field0, $01)) And (local6 = entityy(local53\Field0, $01))) And (local7 = entityz(local53\Field0, $01))) <> 0) Then
                local53\Field3 = local57
                local53\Field5 = local58
                local53\Field6 = local59
                local53\Field9 = local60
                local53\Field8 = local61
                local53\Field10 = local62
                local53\Field11 = local63
                local53\Field12 = local64
                local53\Field13 = local65
                local53\Field14 = local66
                local53\Field4 = local67
                local53\Field7 = local68
                scaleentity(local53\Field0, local57, local57, 1.0, $01)
                entityalpha(local53\Field0, local59)
                entityfx(local53\Field0, local60)
                entityblend(local53\Field0, local61)
                If ((((local62 <> $00) Lor (local63 <> $00)) Lor (local64 <> $00)) <> 0) Then
                    entitycolor(local53\Field0, (Float local62), (Float local63), (Float local64))
                EndIf
                Exit
            EndIf
        Next
    Next
    For local69 = Each events
        removeevent(local69)
    Next
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local69 = (New events)
        local69\Field0 = readbyte(local15)
        local69\Field2 = readfloat(local15)
        local69\Field3 = readfloat(local15)
        local69\Field4 = readfloat(local15)
        local69\Field5 = readfloat(local15)
        local5 = readfloat(local15)
        local7 = readfloat(local15)
        For local0 = Each rooms
            If (((local5 = entityx(local0\Field2, $00)) And (local7 = entityz(local0\Field2, $00))) <> 0) Then
                local69\Field1 = local0
                Exit
            EndIf
        Next
        local69\Field13 = readstring(local15)
        findeventvariable(local69)
    Next
    For local69 = Each events
        Select local69\Field0
            Case $49
                If (0.0 < local69\Field2) Then
                    hidechunks()
                    For local70 = Each chunk
                        removechunk(local70)
                    Next
                    For local71 = Each chunkpart
                        removechunkpart(local71)
                    Next
                    freeentity(i_1499\Field8)
                    i_1499\Field8 = $00
                    For local1 = Each npcs
                        If (local1\Field4 = $10) Then
                            If (local1\Field59 = $03) Then
                                removenpc(local1)
                            EndIf
                        EndIf
                    Next
                    For local73 = Each dummy1499_1
                        removedummy1499_1(local73)
                    Next
                    local69\Field13 = ""
                    local69\Field2 = 0.0
                EndIf
            Case $05
                local69\Field13 = ""
            Case $17
                If (0.0 = local69\Field3) Then
                    positionentity(local69\Field1\Field11[$01], entityx(local69\Field1\Field11[$01], $01), -5.0, entityz(local69\Field1\Field11[$01], $01), $01)
                EndIf
            Case $23
                If (2.0 > local69\Field2) Then
                    rotateentity(local69\Field1\Field11[$01], 85.0, entityyaw(local69\Field1\Field11[$01], $01), 0.0, $01)
                EndIf
        End Select
    Next
    For local74 = Each items
        removeitem(local74)
    Next
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local75 = readstring(local15)
        local14 = readint(local15)
        local76 = readstring(local15)
        local77 = readstring(local15)
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        local7 = readfloat(local15)
        local62 = readbyte(local15)
        local63 = readbyte(local15)
        local64 = readbyte(local15)
        local59 = readfloat(local15)
        local74 = createitem(local75, local14, local5, local6, local7, local62, local63, local64, local59, $00)
        local74\Field1 = local76
        local74\Field0 = local77
        entitytype(local74\Field2, $03, $00)
        local5 = readfloat(local15)
        local6 = readfloat(local15)
        rotateentity(local74\Field2, local5, local6, 0.0, $00)
        local74\Field12 = readfloat(local15)
        local74\Field13 = readfloat(local15)
        local74\Field14 = readfloat(local15)
        local74\Field15 = readbyte(local15)
        If (local74\Field15 <> 0) Then
            hideentity(local74\Field2)
        EndIf
        local78 = readbyte(local15)
        If (local78 = $01) Then
            selecteditem = local74
        EndIf
        local78 = readbyte(local15)
        If (local78 < $42) Then
            inventory(local78) = local74
        EndIf
        For local79 = Each itemtemplates
            If (((local79\Field2 = local14) And (local79\Field1 = local75)) <> 0) Then
                If (local79\Field17 <> 0) Then
                    setanimtime(local74\Field3, readfloat(local15), $00)
                    Exit
                EndIf
            EndIf
        Next
        local74\Field20 = readbyte(local15)
        local74\Field19 = readint(local15)
        If (local74\Field19 > lastitemid) Then
            lastitemid = local74\Field19
        EndIf
        If (readbyte(local15) = $00) Then
            local74\Field17 = local74\Field4\Field7
        Else
            local74\Field17 = local74\Field4\Field8
        EndIf
    Next
    local10 = readint(local15)
    For local8 = $01 To local10 Step $01
        local80 = readint(local15)
        For local81 = Each items
            If (local81\Field19 = local80) Then
                local74 = local81
                Exit
            EndIf
        Next
        For local9 = $00 To (local74\Field20 - $01) Step $01
            local80 = readint(local15)
            If (local80 <> $FFFFFFFF) Then
                For local81 = Each items
                    If (local81\Field19 = local80) Then
                        local74\Field18[local9] = local81
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    For local79 = Each itemtemplates
        local79\Field4 = readbyte(local15)
    Next
    For local3 = Each emitter
        For local0 = Each rooms
            local14 = readbyte(local15)
            If (local14 = $01) Then
                local3\Field10 = local0
                entityparent(local3\Field6, local0\Field2, $01)
            EndIf
        Next
    Next
    escapetimer = readint(local15)
    closefile(local15)
    If (wi\Field5 > $00) Then
        fog\Field0 = 15.0
    ElseIf (wi\Field9 > $00) Then
        fog\Field0 = 9.0
    Else
        fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
    EndIf
    For local8 = $00 To $01 Step $01
        mon_i\Field3[local8] = $01
    Next
    For local0 = Each rooms
        For local8 = $00 To $03 Step $01
            local0\Field19[local8] = Null
        Next
        For local82 = Each rooms
            If (local0 <> local82) Then
                If (local0\Field5 = local82\Field5) Then
                    If ((local0\Field3 + 8.0) = local82\Field3) Then
                        local0\Field19[$00] = local82
                        If (local0\Field20[$00] = Null) Then
                            local0\Field20[$00] = local82\Field20[$02]
                        EndIf
                    ElseIf ((local0\Field3 - 8.0) = local82\Field3) Then
                        local0\Field19[$02] = local82
                        If (local0\Field20[$02] = Null) Then
                            local0\Field20[$02] = local82\Field20[$00]
                        EndIf
                    EndIf
                ElseIf (local0\Field3 = local82\Field3) Then
                    If ((local0\Field5 - 8.0) = local82\Field5) Then
                        local0\Field19[$01] = local82
                        If (local0\Field20[$01] = Null) Then
                            local0\Field20[$01] = local82\Field20[$03]
                        EndIf
                    ElseIf ((local0\Field5 + 8.0) = local82\Field5) Then
                        local0\Field19[$03] = local82
                        If (local0\Field20[$03] = Null) Then
                            local0\Field20[$03] = local82\Field20[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local0\Field19[$00] <> Null) And (local0\Field19[$01] <> Null)) And (local0\Field19[$02] <> Null)) And (local0\Field19[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
        For local2 = Each doors
            If (((local2\Field14 = $00) And (local2\Field19 = $00)) <> 0) Then
                If (local0\Field5 = entityz(local2\Field2, $01)) Then
                    If ((local0\Field3 + 4.0) = entityx(local2\Field2, $01)) Then
                        local0\Field20[$00] = local2
                    ElseIf ((local0\Field3 - 4.0) = entityx(local2\Field2, $01)) Then
                        local0\Field20[$02] = local2
                    EndIf
                ElseIf (local0\Field3 = entityx(local2\Field2, $01)) Then
                    If ((local0\Field5 + 4.0) = entityz(local2\Field2, $01)) Then
                        local0\Field20[$03] = local2
                    ElseIf ((local0\Field5 - 4.0) = entityz(local2\Field2, $01)) Then
                        local0\Field20[$01] = local2
                    EndIf
                EndIf
            EndIf
        Next
    Next
    If (playerroom\Field7\Field6 = $6A) Then
        me\Field10 = -1.0
        teleporttoroom(i_1499\Field4)
    EndIf
    catcherrors((("Uncaught: LoadGame(" + arg0) + ")"))
    Return $00
End Function
