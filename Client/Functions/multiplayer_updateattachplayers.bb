Function multiplayer_updateattachplayers%(arg0.players)
    Local local0.breachtypes
    Local local1%
    Local local2#
    Local local3#
    If (((arg0\Field12 = $00) Or (arg0\Field42 = Null)) <> 0) Then
        Return $00
    EndIf
    local0 = getbreachtype(arg0\Field51)
    If (arg0\Field78 = $01) Then
        If (local0\Field50 <> 0) Then
            For local1 = $01 To $0A Step $01
                attachobject(arg0\Field42\Field7[local1], entityx(getplayerhand(arg0\Field0), $01), entityy(getplayerhand(arg0\Field0), $01), entityz(getplayerhand(arg0\Field0), $01), arg0\Field5, arg0\Field4, 90.0, arg0\Field37, local1)
            Next
        EndIf
        If (local0\Field51 <> 0) Then
            local2 = entityx(arg0\Field15, $01)
            local3 = entityz(arg0\Field15, $01)
            local2 = ((sin((- arg0\Field4)) * 0.025) + local2)
            local3 = ((cos((- arg0\Field4)) * 0.025) + local3)
            attachobject(arg0\Field42\Field4, local2, (entityy(arg0\Field15, $01) + 0.01), local3, (entitypitch(arg0\Field15, $01) + 90.0), entityyaw(arg0\Field15, $01), 0.0, $FFFFFFFF, arg0\Field38)
            attachobject(arg0\Field42\Field5, local2, (entityy(arg0\Field15, $01) + 0.05), local3, entitypitch(arg0\Field15, $01), entityyaw(arg0\Field15, $01), entityroll(arg0\Field15, $00), $FFFFFFFF, arg0\Field39)
            local2 = entityx(arg0\Field23, $01)
            local3 = entityz(arg0\Field23, $01)
            local2 = ((sin((- arg0\Field4)) * 0.1) + local2)
            local3 = ((cos((- arg0\Field4)) * 0.1) + local3)
            attachobject(arg0\Field42\Field6, local2, (entityy(arg0\Field23, $01) - 0.08), local3, (entitypitch(arg0\Field23, $01) + 90.0), (entityyaw(arg0\Field23, $01) - 180.0), (entityroll(arg0\Field23, $01) + 90.0), $FFFFFFFF, arg0\Field41)
        EndIf
        hideentity(arg0\Field42\Field7[$0D])
        hideentity(arg0\Field42\Field7[$0E])
        hideentity(arg0\Field42\Field7[$0F])
        hideentity(arg0\Field42\Field7[$0B])
        hideentity(arg0\Field42\Field7[$0C])
        If (arg0\Field83 = $00) Then
            If (arg0\Field16 <> $00) Then
                Select arg0\Field37
                    Case $0D,$0E,$0F
                        If (local0\Field25 <> 0) Then
                            If (arg0\Field80[$02] = $00) Then
                                arg0\Field80[$02] = findchild(arg0\Field12, local0\Field26[$00])
                            EndIf
                            rotateentity(arg0\Field80[$02], entitypitch(arg0\Field80[$02], $00), (Float local0\Field26[$01]), (Float local0\Field26[$02]), $00)
                        EndIf
                        positionentity(arg0\Field42\Field7[arg0\Field37], entityx(arg0\Field16, $01), entityy(arg0\Field16, $01), entityz(arg0\Field16, $01), $01)
                        rotateentity(arg0\Field42\Field7[arg0\Field37], (entitypitch(arg0\Field16, $01) - 45.0), (entityyaw(arg0\Field16, $01) - 90.0), entityroll(arg0\Field16, $01), $01)
                        showentity(arg0\Field42\Field7[arg0\Field37])
                    Case $0B
                        positionentity(arg0\Field42\Field7[arg0\Field37], entityx(arg0\Field16, $01), entityy(arg0\Field16, $01), entityz(arg0\Field16, $01), $01)
                        rotateentity(arg0\Field42\Field7[arg0\Field37], (entitypitch(arg0\Field16, $01) - 45.0), (entityyaw(arg0\Field16, $01) - 90.0), entityroll(arg0\Field16, $01), $01)
                        showentity(arg0\Field42\Field7[arg0\Field37])
                    Case $0C
                        If (arg0\Field56 = $0F) Then
                            If (0.0 = arg0\Field21) Then
                                arg0\Field21 = entityyaw(arg0\Field18, $00)
                                arg0\Field22 = 0.0
                                arg0\Field57 = $00
                                If (0.0 = arg0\Field21) Then
                                    arg0\Field21 = 0.1
                                EndIf
                            EndIf
                            rotateentity(arg0\Field18, entitypitch(arg0\Field18, $00), arg0\Field22, entityroll(arg0\Field18, $00), $00)
                            If (((74.0 >= arg0\Field22) And (arg0\Field57 = $00)) <> 0) Then
                                arg0\Field22 = curvevalue(75.0, arg0\Field22, 3.0)
                            Else
                                arg0\Field57 = $01
                                arg0\Field22 = curvevalue(0.0, arg0\Field22, 3.0)
                                If (1.0 > arg0\Field22) Then
                                    arg0\Field21 = 0.0
                                    arg0\Field22 = 0.0
                                    arg0\Field56 = $00
                                    arg0\Field57 = $00
                                EndIf
                            EndIf
                        EndIf
                        positionentity(arg0\Field42\Field7[arg0\Field37], entityx(arg0\Field16, $01), entityy(arg0\Field16, $01), entityz(arg0\Field16, $01), $01)
                        rotateentity(arg0\Field42\Field7[arg0\Field37], (entitypitch(arg0\Field16, $01) - 45.0), (entityyaw(arg0\Field16, $01) - 90.0), entityroll(arg0\Field16, $01), $01)
                        showentity(arg0\Field42\Field7[arg0\Field37])
                End Select
                If (arg0\Field68 <> $00) Then
                    If (local0\Field27 <> 0) Then
                        rotateentity(arg0\Field18, entitypitch(arg0\Field18, $00), local0\Field28[$00], local0\Field28[$01], $00)
                    EndIf
                EndIf
            EndIf
        ElseIf (local0\Field29 <> 0) Then
            If (arg0\Field80[$04] = $00) Then
                arg0\Field80[$04] = findchild(arg0\Field12, local0\Field30[$00])
            EndIf
            If (arg0\Field80[$05] = $00) Then
                arg0\Field80[$05] = findchild(arg0\Field12, local0\Field30[$04])
            EndIf
            rotateentity(arg0\Field80[$04], (Float local0\Field30[$01]), (entityyaw(arg0\Field12, $00) + (Float local0\Field30[$02])), (Float local0\Field30[$03]), $01)
            rotateentity(arg0\Field80[$05], (Float local0\Field30[$05]), (entityyaw(arg0\Field12, $00) + (Float local0\Field30[$06])), (Float local0\Field30[$07]), $01)
        EndIf
    EndIf
    If ((arg0\Field33 Or (arg0\Field78 = $00)) <> 0) Then
        If (arg0\Field42\Field8 <> $00) Then
            hideentity(arg0\Field42\Field8)
        EndIf
        hideentity(arg0\Field42\Field6)
        hideentity(arg0\Field42\Field5)
        hideentity(arg0\Field42\Field4)
        For local1 = $01 To $0F Step $01
            hideentity(arg0\Field42\Field7[local1])
        Next
    Else
        If (local0\Field51 = $00) Then
            If (arg0\Field42\Field8 <> $00) Then
                hideentity(arg0\Field42\Field8)
            EndIf
            hideentity(arg0\Field42\Field6)
            hideentity(arg0\Field42\Field5)
            hideentity(arg0\Field42\Field4)
        EndIf
        If (local0\Field50 = $00) Then
            For local1 = $01 To $0F Step $01
                hideentity(arg0\Field42\Field7[local1])
            Next
        EndIf
    EndIf
    Return $00
End Function
