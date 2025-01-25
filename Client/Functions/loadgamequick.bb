Function loadgamequick%(arg0$)
    Local local0.rooms
    Local local1.npcs
    Local local2.doors
    Local local3.emitter
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22#
    Local local23#
    Local local24$
    Local local25%
    Local local27.npcs
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32#
    Local local33#
    Local local34#
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
    Local local82.securitycams
    Local local83#
    Local local84#
    catcherrors((("LoadGameQuick(" + arg0) + ")"))
    local9 = $00
    local10 = $00
    local11 = ""
    local20 = readfile_strict((("Saves\" + arg0) + "\save.cb"))
    gamesaved = $01
    msg\Field0 = ""
    msg\Field1 = 0.0
    msg\Field6 = ""
    msg\Field7 = 0.0
    me\Field56 = $00
    me\Field54 = $00
    me\Field55 = 0.0
    me\Field9 = $01
    me\Field43 = $FFFFFFFF
    readstring(local20)
    readstring(local20)
    local11 = readstring(local20)
    If (local11 <> "1.5") Then
        runtimeerrorex(format(format(getlocalstring("save", "imcompatible"), local11, "{0}"), "1.5", "{1}"))
    EndIf
    readbyte(local20)
    readstring(local20)
    readstring(local20)
    me\Field36 = -0.1
    me\Field37 = 0.0
    me\Field38 = 0.0
    me\Field22 = 0.0
    me\Field30 = 0.0
    me\Field63 = 0.0
    me\Field0 = 0.0
    me\Field4 = 0.0
    me\Field3 = 0.0
    menuopen = $00
    clearconsole()
    clearcheats()
    wireframestate = $00
    wireframe($00)
    readint(local20)
    readint(local20)
    readint(local20)
    readint(local20)
    local4 = readfloat(local20)
    local5 = readfloat(local20)
    local6 = readfloat(local20)
    positionentity(me\Field60, local4, (local5 + 0.3), local6, $00)
    resetentity(me\Field60)
    showentity(me\Field60)
    local4 = readfloat(local20)
    local5 = readfloat(local20)
    local6 = readfloat(local20)
    positionentity(me\Field61, local4, (local5 + 0.3), local6, $00)
    resetentity(me\Field61)
    local4 = readfloat(local20)
    local5 = readfloat(local20)
    rotateentity(me\Field60, local4, local5, 0.0, $00)
    me\Field10 = readfloat(local20)
    me\Field11 = readfloat(local20)
    me\Field12 = readfloat(local20)
    me\Field13 = readfloat(local20)
    me\Field49 = readfloat(local20)
    me\Field35 = readfloat(local20)
    me\Field39 = readbyte(local20)
    me\Field17 = readfloat(local20)
    me\Field18 = readfloat(local20)
    me\Field19 = readfloat(local20)
    me\Field15 = readfloat(local20)
    me\Field14 = readfloat(local20)
    me\Field31 = readfloat(local20)
    me\Field32 = readfloat(local20)
    me\Field33 = readfloat(local20)
    me\Field34 = readfloat(local20)
    msg\Field2 = readstring(local20)
    me\Field64 = readint(local20)
    me\Field65 = readbyte(local20)
    me\Field26 = readfloat(local20)
    me\Field25 = readbyte(local20)
    me\Field21 = readfloat(local20)
    me\Field23 = readfloat(local20)
    me\Field24 = readfloat(local20)
    me\Field50 = readfloat(local20)
    me\Field51 = readfloat(local20)
    me\Field5 = readfloat(local20)
    me\Field53 = readint(local20)
    i_005\Field0 = readbyte(local20)
    i_500\Field0 = readbyte(local20)
    For local7 = $00 To $06 Step $01
        i_1025\Field0[local7] = readfloat(local20)
    Next
    For local7 = $00 To $04 Step $01
        i_1025\Field1[local7] = readfloat(local20)
    Next
    i_008\Field0 = readfloat(local20)
    i_008\Field1 = readbyte(local20)
    i_409\Field0 = readfloat(local20)
    i_409\Field1 = readbyte(local20)
    i_035\Field0 = readbyte(local20)
    local21 = readbyte(local20)
    selecteddifficulty = difficulties[local21]
    If (local21 = $04) Then
        selecteddifficulty\Field2 = readbyte(local20)
        selecteddifficulty\Field3 = readbyte(local20)
        selecteddifficulty\Field4 = readbyte(local20)
        selecteddifficulty\Field9 = readbyte(local20)
    EndIf
    maxitemamount = (selecteddifficulty\Field9 + ((0.0 < i_1025\Field1[$00]) Shl $01))
    Dim inventory.items((selecteddifficulty\Field9 + $02))
    wi\Field1 = readfloat(local20)
    wi\Field0 = readbyte(local20)
    wi\Field3 = readbyte(local20)
    wi\Field4 = readbyte(local20)
    wi\Field2 = readbyte(local20)
    wi\Field5 = readbyte(local20)
    wi\Field9 = readbyte(local20)
    i_1499\Field0 = readbyte(local20)
    i_1499\Field1 = readfloat(local20)
    i_1499\Field2 = readfloat(local20)
    i_1499\Field3 = readfloat(local20)
    i_1499\Field5 = readfloat(local20)
    i_1499\Field6 = readfloat(local20)
    i_1499\Field7 = readfloat(local20)
    local22 = readfloat(local20)
    local23 = readfloat(local20)
    i_966\Field1 = readfloat(local20)
    i_966\Field0 = readfloat(local20)
    i_1048a\Field0 = readfloat(local20)
    i_1048a\Field1 = readbyte(local20)
    i_268\Field0 = readbyte(local20)
    i_268\Field1 = readfloat(local20)
    i_427\Field0 = readbyte(local20)
    i_427\Field1 = readfloat(local20)
    i_714\Field0 = readbyte(local20)
    i_294\Field0 = readbyte(local20)
    randomseed = readstring(local20)
    secondarylighton = readfloat(local20)
    lightvolume = readfloat(local20)
    isblackout = readbyte(local20)
    previsblackout = readbyte(local20)
    remotedooron = readbyte(local20)
    soundtransmission = readbyte(local20)
    key2_spawnrate = readbyte(local20)
    clears2imap(unlockedachievements)
    Repeat
        local24 = readstring(local20)
        If (local24 = "EOA") Then
            Exit
        EndIf
        s2imapset(unlockedachievements, local24, $01)
    Forever
    usedconsole = readbyte(local20)
    mtftimer = readfloat(local20)
    remove714timer = readfloat(local20)
    removehazmattimer = readfloat(local20)
    For local4 = 0.0 To 21.0 Step 1.0
        For local5 = 0.0 To 21.0 Step 1.0
            currmapgrid\Field0[(Int ((local5 * 21.0) + local4))] = readbyte(local20)
            currmapgrid\Field2[(Int ((local5 * 21.0) + local4))] = readbyte(local20)
        Next
    Next
    For local3 = Each emitter
        entityparent(local3\Field6, $00, $01)
    Next
    If (readint(local20) <> $71) Then
        runtimeerrorex(getlocalstring("save", "corrupted_1"))
    EndIf
    For local1 = Each npcs
        removenpc(local1)
    Next
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local25 = readbyte(local20)
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local1 = createnpc(local25, local4, local5, local6)
        Select local25
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
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        rotateentity(local1\Field3, local4, local5, local6, $00)
        local1\Field10 = readfloat(local20)
        local1\Field11 = readfloat(local20)
        local1\Field12 = readfloat(local20)
        local1\Field13 = readint(local20)
        local1\Field26 = (Float readbyte(local20))
        local1\Field30 = readfloat(local20)
        local1\Field29 = readint(local20)
        local1\Field24 = readfloat(local20)
        local1\Field15 = readfloat(local20)
        local1\Field28 = readfloat(local20)
        forcesetnpcid(local1, readint(local20))
        local1\Field35 = readint(local20)
        local1\Field36 = readfloat(local20)
        local1\Field37 = readfloat(local20)
        local1\Field38 = readfloat(local20)
        local1\Field25 = readstring(local20)
        If (local1\Field25 <> "") Then
            local13 = loadtexture_strict(local1\Field25, $01, $00, $01)
            entitytexture(local1\Field0, local13, $00, $00)
            deletesingletextureentryfromcache(local13, $00)
            local13 = $00
        EndIf
        local1\Field63 = readbyte(local20)
        If (local1\Field63 <> 0) Then
            createnpcasset(local1)
        EndIf
        local1\Field64 = readbyte(local20)
        If (local1\Field64 <> 0) Then
            local1\Field14 = readfloat(local20)
            setanimtime(local1\Field0, local1\Field14, $00)
        EndIf
        local1\Field65 = readbyte(local20)
        local1\Field50 = readbyte(local20)
        local1\Field60 = readint(local20)
        local1\Field61 = readfloat(local20)
        If (0.0 < local1\Field61) Then
            scaleentity(local1\Field0, local1\Field61, local1\Field61, local1\Field61, $00)
        EndIf
        changenpctextureid(local1, (readbyte(local20) - $01))
        local1\Field43 = readbyte(local20)
    Next
    For local1 = Each npcs
        If (local1\Field35 <> $00) Then
            For local27 = Each npcs
                If (local27 <> local1) Then
                    If (local27\Field5 = local1\Field35) Then
                        local1\Field34 = local27
                    EndIf
                EndIf
            Next
        EndIf
    Next
    If (readint(local20) <> $278) Then
        runtimeerrorex(getlocalstring("save", "corrupted_2"))
    EndIf
    i_zone\Field0[$00] = readbyte(local20)
    i_zone\Field0[$01] = readbyte(local20)
    i_zone\Field1 = readbyte(local20)
    i_zone\Field2 = readbyte(local20)
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local28 = readint(local20)
        local29 = readint(local20)
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local30 = readbyte(local20)
        local31 = readint(local20)
        local10 = readbyte(local20)
        If (360.0 <= (Float local29)) Then
            local29 = (Int ((Float local29) - 360.0))
        EndIf
        For local0 = Each rooms
            If (((local4 = local0\Field3) And (local6 = local0\Field5)) <> 0) Then
                Exit
            EndIf
        Next
        If (local10 = $01) Then
            playerroom = local0
        EndIf
        For local8 = $00 To $0B Step $01
            local12 = readint(local20)
            If (local12 > $00) Then
                For local1 = Each npcs
                    If (local1\Field5 = local12) Then
                        local0\Field15[local8] = local1
                        Exit
                    EndIf
                Next
            EndIf
        Next
        For local8 = $00 To $03 Step $01
            local12 = readbyte(local20)
            If (local12 = $00) Then
                rotateentity(local0\Field13[local8]\Field0, 80.0, entityyaw(local0\Field13[local8]\Field0, $00), 0.0, $00)
            ElseIf (local12 = $01) Then
                rotateentity(local0\Field13[local8]\Field0, -80.0, entityyaw(local0\Field13[local8]\Field0, $00), 0.0, $00)
            EndIf
        Next
        If (readbyte(local20) = $01) Then
            For local5 = 0.0 To 18.0 Step 1.0
                For local4 = 0.0 To 18.0 Step 1.0
                    readbyte(local20)
                    readbyte(local20)
                Next
            Next
        ElseIf (local0\Field18 <> Null) Then
            destroymt(local0\Field18, $01)
            Delete local0\Field18
        EndIf
        If (readbyte(local20) > $00) Then
            For local5 = 0.0 To 9.0 Step 1.0
                For local4 = 0.0 To 9.0 Step 1.0
                    readbyte(local20)
                Next
            Next
            local32 = readfloat(local20)
            local33 = readfloat(local20)
            local34 = readfloat(local20)
        ElseIf (local0\Field10 <> Null) Then
            destroyforest(local0\Field10, $01)
            Delete local0\Field10
        EndIf
    Next
    For local0 = Each rooms
        If (((local22 = local0\Field3) And (local23 = local0\Field5)) <> 0) Then
            i_1499\Field4 = local0
            Exit
        EndIf
    Next
    If (readint(local20) <> $3BA) Then
        runtimeerrorex(getlocalstring("save", "corrupted_3"))
    EndIf
    For local3 = Each emitter
        freeemitter(local3, $01)
    Next
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local12 = readint(local20)
        local10 = readbyte(local20)
        local3 = setemitter(local0, local4, local5, local6, local12)
        local3\Field11 = local10
        forcesetemitterid(local3, readint(local20))
    Next
    For local0 = Each rooms
        For local8 = $00 To $07 Step $01
            local12 = readint(local20)
            If (local12 > $00) Then
                For local3 = Each emitter
                    If (local3\Field5 = local12) Then
                        local0\Field17[local8] = local3
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    bk\Field0 = readbyte(local20)
    bk\Field1 = readfloat(local20)
    bk\Field2 = readfloat(local20)
    local35 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
    local36 = loadtexture_strict("GFX\Map\Textures\containment_doors_Corrosive.png", $01, $00, $01)
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local37 = readbyte(local20)
        local38 = readfloat(local20)
        local39 = readbyte(local20)
        local40 = readbyte(local20)
        local41 = readfloat(local20)
        local42 = readfloat(local20)
        local43 = readfloat(local20)
        local44 = readfloat(local20)
        local45 = readfloat(local20)
        local46 = readfloat(local20)
        local47 = readfloat(local20)
        local48 = readbyte(local20)
        local49 = readbyte(local20)
        local50 = readbyte(local20)
        For local2 = Each doors
            If ((((local4 = entityx(local2\Field2, $01)) And (local5 = entityy(local2\Field2, $01))) And (local6 = entityz(local2\Field2, $01))) <> 0) Then
                local2\Field6 = local37
                local2\Field8 = local38
                local2\Field4 = local39
                local2\Field20 = local40
                local2\Field12 = (Int local46)
                local2\Field13 = local47
                local2\Field22 = local48
                local2\Field23 = local49
                local2\Field27 = local50
                positionentity(local2\Field0, local41, local5, local42, $01)
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
                    positionentity(local2\Field1, local44, local5, local45, $01)
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
    If (readint(local20) <> $735) Then
        runtimeerrorex(getlocalstring("save", "corrupted_4"))
    EndIf
    For local53 = Each decals
        removedecal(local53)
    Next
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local12 = readint(local20)
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local54 = readfloat(local20)
        local55 = readfloat(local20)
        local56 = readfloat(local20)
        local53 = createdecal(local12, local4, local5, local6, local54, local55, local56, 1.0, 1.0, $00, $01, $00, $00, $00)
        local57 = readfloat(local20)
        local58 = readfloat(local20)
        local59 = readfloat(local20)
        local60 = readbyte(local20)
        local61 = readbyte(local20)
        local62 = readbyte(local20)
        local63 = readbyte(local20)
        local64 = readbyte(local20)
        local65 = readfloat(local20)
        local66 = readfloat(local20)
        local67 = readfloat(local20)
        local68 = readfloat(local20)
        For local53 = Each decals
            If ((((local4 = entityx(local53\Field0, $01)) And (local5 = entityy(local53\Field0, $01))) And (local6 = entityz(local53\Field0, $01))) <> 0) Then
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
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local69 = (New events)
        local69\Field0 = readbyte(local20)
        local69\Field2 = readfloat(local20)
        local69\Field3 = readfloat(local20)
        local69\Field4 = readfloat(local20)
        local69\Field5 = readfloat(local20)
        local4 = readfloat(local20)
        local6 = readfloat(local20)
        For local0 = Each rooms
            If (((local4 = entityx(local0\Field2, $00)) And (local6 = entityz(local0\Field2, $00))) <> 0) Then
                local69\Field1 = local0
                Exit
            EndIf
        Next
        local69\Field13 = readstring(local20)
        findeventvariable(local69)
    Next
    For local69 = Each events
        Select local69\Field0
            Case $03
                If (local69\Field1\Field11[$00] = $00) Then
                    local69\Field1\Field11[$00] = createpivot($00)
                    local69\Field1\Field11[$01] = createpivot($00)
                EndIf
            Case $49
                If (1.0 = local69\Field2) Then
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
            Case $39
                If (1.0 = local69\Field2) Then
                    showentity(local69\Field1\Field10\Field4)
                EndIf
            Case $23
                If (2.0 > local69\Field2) Then
                    rotateentity(local69\Field1\Field11[$01], 85.0, entityyaw(local69\Field1\Field11[$01], $01), 0.0, $01)
                EndIf
            Case $10
                If (local69\Field1\Field11[$07] = $00) Then
                    local69\Field1\Field11[$07] = loadrmesh("GFX\Map\cont2_1123_cell.rmesh", Null, $01)
                    scaleentity(local69\Field1\Field11[$07], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    positionentity(local69\Field1\Field11[$07], local69\Field1\Field3, local69\Field1\Field4, local69\Field1\Field5, $00)
                    rotateentity(local69\Field1\Field11[$07], 0.0, (Float local69\Field1\Field6), 0.0, $00)
                    entityparent(local69\Field1\Field11[$07], local69\Field1\Field2, $01)
                    hideentity(local69\Field1\Field11[$07])
                EndIf
            Case $0E
                If (2170.0 > local69\Field3) Then
                    local13 = loadtexture_strict("GFX\Map\Textures\scp_012(1).png", $01, $00, $01)
                    entitytexture(local69\Field1\Field11[$03], local13, $00, $00)
                    deletesingletextureentryfromcache(local13, $00)
                EndIf
            Case $16
                If (1.0 = local69\Field2) Then
                    hideentity(local69\Field1\Field11[$01])
                EndIf
            Case $17
                setanimtime(local69\Field1\Field11[$05], (((Float (0.0 <> local69\Field2)) * 119.0) + 1.0), $00)
            Case $32
                setanimtime(local69\Field1\Field11[$00], (((Float (2.0 = local69\Field2)) * 239.0) + 1.0), $00)
        End Select
    Next
    For local74 = Each items
        removeitem(local74)
    Next
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local75 = readstring(local20)
        local12 = readint(local20)
        local76 = readstring(local20)
        local77 = readstring(local20)
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        local6 = readfloat(local20)
        local62 = readbyte(local20)
        local63 = readbyte(local20)
        local64 = readbyte(local20)
        local59 = readfloat(local20)
        local74 = createitem(local75, local12, local4, local5, local6, local62, local63, local64, local59, $00)
        local74\Field1 = local76
        local74\Field0 = local77
        entitytype(local74\Field2, $03, $00)
        local4 = readfloat(local20)
        local5 = readfloat(local20)
        rotateentity(local74\Field2, local4, local5, 0.0, $00)
        local74\Field12 = readfloat(local20)
        local74\Field13 = readfloat(local20)
        local74\Field14 = readfloat(local20)
        local74\Field15 = readbyte(local20)
        If (local74\Field15 <> 0) Then
            hideentity(local74\Field2)
        EndIf
        local78 = readbyte(local20)
        If (local78 = $01) Then
            selecteditem = local74
        EndIf
        local78 = readbyte(local20)
        If (local78 < $42) Then
            inventory(local78) = local74
        EndIf
        For local79 = Each itemtemplates
            If (((local79\Field2 = local12) And (local79\Field1 = local75)) <> 0) Then
                If (local79\Field17 <> 0) Then
                    setanimtime(local74\Field3, readfloat(local20), $00)
                    Exit
                EndIf
            EndIf
        Next
        local74\Field20 = readbyte(local20)
        local74\Field19 = readint(local20)
        If (local74\Field19 > lastitemid) Then
            lastitemid = local74\Field19
        EndIf
        If (readbyte(local20) = $00) Then
            local74\Field17 = local74\Field4\Field7
        Else
            local74\Field17 = local74\Field4\Field8
        EndIf
    Next
    local9 = readint(local20)
    For local7 = $01 To local9 Step $01
        local80 = readint(local20)
        For local81 = Each items
            If (local81\Field19 = local80) Then
                local74 = local81
                Exit
            EndIf
        Next
        For local8 = $00 To (local74\Field20 - $01) Step $01
            local80 = readint(local20)
            If (local80 <> $FFFFFFFF) Then
                For local81 = Each items
                    If (local81\Field19 = local80) Then
                        local74\Field18[local8] = local81
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    For local79 = Each itemtemplates
        local79\Field4 = readbyte(local20)
    Next
    For local3 = Each emitter
        For local0 = Each rooms
            local12 = readbyte(local20)
            If (local12 = $01) Then
                local3\Field10 = local0
                entityparent(local3\Field6, local0\Field2, $01)
            EndIf
        Next
    Next
    escapetimer = readint(local20)
    For local82 = Each securitycams
        local82\Field12 = $00
    Next
    entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
    closefile(local20)
    clearfogcolor()
    updatelightstimer = 0.0
    d_i\Field10 = $00
    If (wi\Field0 = $00) Then
        hideentity(t\Field3[$01])
    EndIf
    If (wi\Field2 = $00) Then
        hideentity(t\Field3[$02])
    EndIf
    If (wi\Field5 > $00) Then
        fog\Field0 = 15.0
    ElseIf (wi\Field9 > $00) Then
        fog\Field0 = 9.0
    Else
        fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
    EndIf
    If (sky <> $00) Then
        freeentity(sky)
        sky = $00
    EndIf
    For local0 = Each rooms
        Select local0\Field7\Field6
            Case $47
                If (local0\Field11[$00] <> $00) Then
                    freeentity(local0\Field11[$00])
                    local0\Field11[$00] = $00
                    local83 = entityx(local0\Field11[$09], $01)
                    local84 = entityz(local0\Field11[$09], $01)
                    freeentity(local0\Field11[$09])
                    local0\Field11[$09] = $00
                    local0\Field11[$0A] = $00
                    local0\Field11[$09] = createpivot($00)
                    positionentity(local0\Field11[$09], local83, (local0\Field4 + 3.875), local84, $01)
                    entityparent(local0\Field11[$09], local0\Field2, $01)
                    local83 = entityx(local0\Field11[$0D], $01)
                    local84 = entityz(local0\Field11[$0D], $01)
                    freeentity(local0\Field11[$0D])
                    local0\Field11[$0D] = $00
                    local0\Field11[$0D] = loadmesh_strict("GFX\Map\gateawall1.b3d", local0\Field2)
                    positionentity(local0\Field11[$0D], local83, (local0\Field4 - 4.082031), local84, $01)
                    entitycolor(local0\Field11[$0D], 25.0, 25.0, 25.0)
                    entitytype(local0\Field11[$0D], $01, $00)
                    local83 = entityx(local0\Field11[$0E], $01)
                    local84 = entityz(local0\Field11[$0E], $01)
                    freeentity(local0\Field11[$0E])
                    local0\Field11[$0E] = $00
                    local0\Field11[$0E] = loadmesh_strict("GFX\Map\gateawall2.b3d", local0\Field2)
                    positionentity(local0\Field11[$0E], local83, (local0\Field4 - 4.082031), local84, $01)
                    entitycolor(local0\Field11[$0E], 25.0, 25.0, 25.0)
                    entitytype(local0\Field11[$0E], $01, $00)
                EndIf
                If (local0\Field11[$0C] <> $00) Then
                    freeentity(local0\Field11[$0C])
                    local0\Field11[$0C] = $00
                    freeentity(local0\Field11[$11])
                    local0\Field11[$11] = $00
                EndIf
            Case $49
                If (local0\Field11[$00] <> $00) Then
                    local83 = entityx(local0\Field11[$00], $01)
                    local84 = entityz(local0\Field11[$00], $01)
                    freeentity(local0\Field11[$00])
                    local0\Field11[$00] = $00
                    local0\Field11[$00] = createpivot(local0\Field2)
                    positionentity(local0\Field11[$00], local83, (local0\Field4 - 3.972656), local84, $01)
                EndIf
            Case $29
                update035label(local0\Field11[$04])
        End Select
    Next
    hidedistance = 17.0
    catcherrors((("Uncaught: LoadGameQuick(" + arg0) + ")"))
    Return $00
End Function
