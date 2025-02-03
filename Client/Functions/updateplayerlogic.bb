Function updateplayerlogic%(arg0.mp_player)
    Local local0%
    Local local1%
    Local local2.items
    Local local3.rooms
    Local local4%
    Local local6%
    Local local7.decals
    Local local9#
    Local local10.items
    Local local11.items
    Local local12#
    Local local13%
    Local local15%
    updateplayeradjacency(arg0)
    arg0\Field28 = curvevalue(0.0, arg0\Field28, 50.0)
    If (arg0\Field4 <> Null) Then
        If (arg0\Field4\Field4 = $00) Then
            arg0\Field31 = $00
            If (readbool(arg0\Field4\Field17, $01) <> 0) Then
                arg0\Field31 = $01
            EndIf
            If (readbool(arg0\Field4\Field17, $02) <> 0) Then
                arg0\Field31 = $02
            EndIf
            local1 = (arg0\Field5 = mp_getmyindex())
            If (local1 <> 0) Then
                If (-1.0 >= me\Field41) Then
                    arg0\Field31 = $01
                EndIf
                If (1.0 <= me\Field41) Then
                    arg0\Field31 = $02
                EndIf
            EndIf
            arg0\Field26 = $00
            If (((arg0\Field4\Field27 > $00) And (arg0\Field4\Field27 < $3E8)) <> 0) Then
                local2 = mp_items[arg0\Field4\Field27]
                If (((local2 <> Null) And (local2\Field27 = arg0\Field5)) <> 0) Then
                    arg0\Field26 = local2\Field19
                EndIf
            EndIf
            If ((local1 And (selecteditem <> Null)) <> 0) Then
                arg0\Field26 = selecteditem\Field19
            EndIf
            If (arg0\Field4\Field20 > $00) Then
                local3 = mp_rooms[arg0\Field4\Field20]
                local4 = $00
                If (local3 <> Null) Then
                    If (arg0\Field4\Field19 <> 0) Then
                        If (arg0\Field4\Field21 < $04) Then
                            local4 = local3\Field13[arg0\Field4\Field21]\Field0
                            If (1.0 > entitydistancesquared(local4, arg0\Field18)) Then
                                rotateentity(local4, clamp(curvevalue(arg0\Field4\Field22, entitypitch(local4, $01), 4.0), -80.0, 80.0), entityyaw(local4, $01), 0.0, $01)
                            EndIf
                        EndIf
                    Else
                        Select local3\Field7\Field6
                            Case $06
                                If (arg0\Field4\Field21 < $02) Then
                                    local4 = local3\Field11[arg0\Field4\Field21]
                                    If (2.0 > entitydistancesquared(local4, arg0\Field18)) Then
                                        rotateentity(local4, entitypitch(local4, $01), entityyaw(local4, $01), curveangle(arg0\Field4\Field22, entityroll(local4, $01), 4.0), $01)
                                    EndIf
                                EndIf
                            Case $39
                                If (arg0\Field4\Field21 = $01) Then
                                    local4 = local3\Field11[arg0\Field4\Field21]
                                    If (2.0 > entitydistancesquared(local4, arg0\Field18)) Then
                                        rotateentity(local4, clamp(curvevalue(arg0\Field4\Field22, entitypitch(local4, $01), 4.0), 35.0, 89.0), entityyaw(local4, $01), 0.0, $01)
                                    EndIf
                                EndIf
                        End Select
                    EndIf
                EndIf
            EndIf
            If (1.0 < arg0\Field4\Field6) Then
                If (getplayerattachmodel(arg0, $03) <> $0D) Then
                    arg0\Field4\Field7 = min((((min(arg0\Field4\Field6, 3.5) / 300.0) * fps\Field7[$00]) + arg0\Field4\Field7), 100.0)
                EndIf
                If (min(arg0\Field4\Field6, 4.0) > rnd(200.0, 0.0)) Then
                    local6 = createpivot($00)
                    positionentity(local6, (entityx(arg0\Field18, $00) + rnd(-0.05, 0.05)), (entityy(arg0\Field18, $00) - 0.05), (entityz(arg0\Field18, $00) + rnd(-0.05, 0.05)), $00)
                    turnentity(local6, 90.0, 0.0, 0.0, $00)
                    entitypick(local6, 0.3)
                    local7 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, (rnd(0.03, 0.08) * min(arg0\Field4\Field6, 2.5)), 1.0, $00, $01, $00, $00, $00)
                    local7\Field4 = rnd(0.001, 0.0015)
                    local7\Field5 = (local7\Field3 + rnd(0.008, 0.009))
                    If (mp_rooms[arg0\Field22] <> Null) Then
                        entityparent(local7\Field0, mp_rooms[arg0\Field22]\Field2, $01)
                    EndIf
                    freeentity(local6)
                    local6 = $00
                    mp_server_synchronizedecal(local7, arg0\Field22)
                EndIf
                If (100.0 <= arg0\Field4\Field7) Then
                    mp_terminateplayer(arg0, $00, $00)
                EndIf
            EndIf
            If (0.0 > arg0\Field4\Field10) Then
                If (-20.0 >= arg0\Field4\Field10) Then
                    Select selecteddifficulty\Field4
                        Case $00
                            arg0\Field4\Field11 = rnd(840.0, 980.0)
                        Case $01
                            arg0\Field4\Field11 = rnd(700.0, 840.0)
                        Case $02
                            arg0\Field4\Field11 = rnd(560.0, 700.0)
                        Case $03
                            arg0\Field4\Field11 = rnd(420.0, 560.0)
                    End Select
                    arg0\Field4\Field10 = arg0\Field4\Field11
                EndIf
                arg0\Field4\Field10 = (arg0\Field4\Field10 - fps\Field7[$01])
            Else
                arg0\Field4\Field10 = (arg0\Field4\Field10 - ((fps\Field7[$01] * (((Float arg0\Field4\Field38) * 0.5) + 1.0)) * arg0\Field4\Field12))
                If (((0.0 < arg0\Field4\Field14) And (getplayerattachmodel(arg0, $00) = $00)) <> 0) Then
                    arg0\Field4\Field10 = (arg0\Field4\Field10 - (min(((arg0\Field4\Field14 / 70.0) + 1.0), 5.0) * fps\Field7[$01]))
                EndIf
            EndIf
            If (0.0 < arg0\Field4\Field13) Then
                arg0\Field4\Field13 = (arg0\Field4\Field13 - (fps\Field7[$01] / 70.0))
            Else
                arg0\Field4\Field12 = 1.0
            EndIf
            If (readbool(arg0\Field4\Field17, $00) <> 0) Then
                arg0\Field4\Field10 = clamp(arg0\Field4\Field10, -10.0, 0.0)
            EndIf
            If (local1 <> 0) Then
                arg0\Field4\Field10 = me\Field10
                arg0\Field4\Field18 = wi\Field7
                arg0\Field4\Field7 = me\Field32
            EndIf
            arg0\Field29 = (((-16.0 < arg0\Field4\Field10) And (-6.0 > arg0\Field4\Field10)) Lor arg0\Field4\Field18)
            If (0.0 < arg0\Field4\Field9) Then
                arg0\Field4\Field10 = arg0\Field4\Field11
                arg0\Field4\Field9 = max((arg0\Field4\Field9 - fps\Field7[$00]), 0.0)
            EndIf
            arg0\Field4\Field0 = (arg0\Field4\Field0 + fps\Field7[$01])
            If (17.5 <= arg0\Field4\Field0) Then
                If (((getplayerattachmodel(arg0, $02) = $0F) Lor (getplayerattachmodel(arg0, $02) = $10)) <> 0) Then
                    setplayerinvisible(arg0, (0.0 < arg0\Field4\Field30))
                    arg0\Field4\Field31 = 140.0
                    If (getplayerattachmodel(arg0, $02) = $10) Then
                        local9 = (((((Float (getplayerattachmodel(arg0, $04) = $11)) * 0.5) + 1.0) + (Float (getplayerattachmodel(arg0, $00) = $04))) * (arg0\Field4\Field0 / 2.0))
                    Else
                        local9 = (((((Float (getplayerattachmodel(arg0, $04) = $11)) * 0.5) + 1.0) + (Float (getplayerattachmodel(arg0, $00) = $04))) * arg0\Field4\Field0)
                    EndIf
                    arg0\Field4\Field30 = max((arg0\Field4\Field30 - local9), 0.0)
                Else
                    If (0.0 >= arg0\Field4\Field31) Then
                        arg0\Field4\Field30 = min((arg0\Field4\Field30 + arg0\Field4\Field0), 700.0)
                    Else
                        arg0\Field4\Field31 = (arg0\Field4\Field31 - arg0\Field4\Field0)
                    EndIf
                    setplayerinvisible(arg0, $00)
                EndIf
                If (arg0\Field26 > $00) Then
                    local10 = mp_items[arg0\Field26]
                    local10\Field12 = max((local10\Field12 - ((arg0\Field4\Field0 * 0.003) * (Float (local10\Field25 = $03)))), 0.0)
                EndIf
                arg0\Field4\Field26 = $00
                If (((arg0\Field4\Field24 > $00) And (arg0\Field4\Field25 < $3E8)) <> 0) Then
                    local11 = mp_items[arg0\Field4\Field25]
                    If (((local11 <> Null) And (local11\Field27 = arg0\Field5)) <> 0) Then
                        arg0\Field4\Field26 = arg0\Field4\Field24
                    EndIf
                EndIf
                If (0.0 < arg0\Field4\Field8) Then
                    local12 = (arg0\Field4\Field0 / 70.0)
                    arg0\Field4\Field8 = max((arg0\Field4\Field8 - local12), 0.0)
                    arg0\Field4\Field7 = min((arg0\Field4\Field7 + (local12 / 3.0)), 100.0)
                    arg0\Field4\Field6 = max((arg0\Field4\Field6 - (local12 / 30.0)), 0.0)
                EndIf
                arg0\Field4\Field3 = (arg0\Field4\Field3 - arg0\Field4\Field0)
                If (((arg0\Field4\Field6 < arg0\Field4\Field2) And (0.0 >= arg0\Field4\Field3)) <> 0) Then
                    arg0\Field4\Field6 = min(arg0\Field4\Field6, 100.0)
                EndIf
                local13 = $00
                setplayerattachmodel(arg0, $00, $00)
                setplayerattachmodel(arg0, $01, $00)
                setplayerattachmodel(arg0, $02, $00)
                setplayerattachmodel(arg0, $03, $00)
                setplayerattachmodel(arg0, $04, $00)
                If (local1 <> 0) Then
                    For local0 = $00 To $04 Step $01
                        arg0\Field4\Field23[local0] = myplayerlogic\Field1[local0]
                    Next
                EndIf
                For local0 = $00 To $04 Step $01
                    If ((((arg0\Field4\Field23[local0] > $00) And (arg0\Field4\Field23[local0] < $3E8)) And (mp_items[arg0\Field4\Field23[local0]] <> Null)) <> 0) Then
                        local10 = mp_items[arg0\Field4\Field23[local0]]
                        If (local10\Field27 = arg0\Field5) Then
                            local10\Field12 = max((local10\Field12 - ((arg0\Field4\Field0 * 0.003) * (Float (local10\Field25 = $03)))), 0.0)
                            Select local10\Field4\Field2
                                Case $38
                                    setplayerattachmodel(arg0, $00, $01)
                                Case $39
                                    setplayerattachmodel(arg0, $00, $02)
                                Case $3A
                                    setplayerattachmodel(arg0, $00, $03)
                                Case $3B
                                    setplayerattachmodel(arg0, $00, $04)
                                Case $40
                                    setplayerattachmodel(arg0, $00, $08)
                                Case $42
                                    setplayerattachmodel(arg0, $00, $09)
                                Case $41
                                    setplayerattachmodel(arg0, $00, $0A)
                                Case $43
                                    setplayerattachmodel(arg0, $00, $0B)
                                Case $44
                                    setplayerattachmodel(arg0, $00, $0C)
                                Case $27
                                    setplayerattachmodel(arg0, $01, $05)
                                Case $28
                                    setplayerattachmodel(arg0, $01, $06)
                                Case $26
                                    setplayerattachmodel(arg0, $02, $07)
                                Case $0D
                                    setplayerattachmodel(arg0, $02, $0E)
                                Case $0E
                                    setplayerattachmodel(arg0, $02, $0F)
                                Case $0F
                                    setplayerattachmodel(arg0, $02, $10)
                                Case $14
                                    setplayerattachmodel(arg0, $03, $0D)
                                Case $1B
                                    setplayerattachmodel(arg0, $04, $11)
                                Case $1A
                                    setplayerattachmodel(arg0, $04, $12)
                                Case $3C,$3D,$3E,$3F
                                    setplayerattachmodel(arg0, $00, $00)
                                    setplayerattachmodel(arg0, $01, $00)
                                    setplayerattachmodel(arg0, $02, $00)
                                    settempplayermodel(arg0, $02)
                                    If (local10\Field4\Field2 = $3F) Then
                                        setplayermodeltexture(arg0, local15, $00)
                                    EndIf
                                    local13 = $01
                                    Exit
                            End Select
                        EndIf
                    EndIf
                Next
                If (((local13 = $00) And (getpreviousplayermodel(arg0) > $00)) <> 0) Then
                    setplayermodel(arg0, getpreviousplayermodel(arg0), $01)
                EndIf
                arg0\Field4\Field0 = 0.0
            EndIf
            Return $00
        EndIf
        If (getplayermodel(arg0) <> $00) Then
            setplayerattachmodel(arg0, $00, $00)
            setplayerattachmodel(arg0, $01, $00)
            setplayerattachmodel(arg0, $02, $00)
            setplayerattachmodel(arg0, $03, $00)
            setplayerattachmodel(arg0, $04, $00)
            setplayermodel(arg0, $00, $00)
        EndIf
        mp_updateterminatedplayer(arg0)
    EndIf
    Return $00
End Function
