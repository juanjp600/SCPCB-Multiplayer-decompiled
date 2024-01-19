Function multiplayer_manipulateplayerbones%(arg0.players)
    Local local0#
    Local local1#
    Local local2#
    Local local3%
    Local local5.breachtypes
    If (((arg0\Field12 = $00) Or (arg0\Field78 = $00)) <> 0) Then
        Return $00
    EndIf
    arg0\Field10 = curveangle(arg0\Field5, arg0\Field10, 7.0)
    local0 = entityyaw(arg0\Field13, $00)
    local1 = arg0\Field10
    local2 = arg0\Field10
    local3 = $00
    arg0\Field97 = 0.0
    If (readbool(arg0\Field79, $04) <> 0) Then
        arg0\Field97 = -25.0
    EndIf
    If (readbool(arg0\Field79, $07) <> 0) Then
        arg0\Field97 = 25.0
    EndIf
    arg0\Field98 = curvevalue(arg0\Field97, arg0\Field98, 7.0)
    If (arg0\Field40 <> $00) Then
        If (((arg0\Field37 <> $00) And (arg0\Field17 <> $00)) <> 0) Then
            rotateentity(arg0\Field17, (entitypitch(arg0\Field17, $00) + local1), entityyaw(arg0\Field17, $01), (entityroll(arg0\Field17, $01) + arg0\Field98), $01)
        EndIf
        rotateentity(arg0\Field15, local2, local0, -90.0, $01)
        Return $00
    EndIf
    Select arg0\Field51
        Case model_966
            arg0\Field20 = -90.0
        Case model_939
            arg0\Field20 = entityroll(arg0\Field15, $01)
        Case model_860
            local2 = (local2 - 90.0)
            arg0\Field20 = 90.0
        Case ntf_model
            If (arg0\Field37 <> $00) Then
                rotateentity(arg0\Field17, arg0\Field98, entityyaw(arg0\Field17, $01), local1, $01)
            EndIf
            rotateentity(arg0\Field15, 0.0, wrapangle((local0 - 90.0)), local2, $01)
            Return $00
        Default
            local5 = getbreachtype(arg0\Field51)
            If (0.0 <> local5\Field43) Then
                arg0\Field20 = local5\Field43
            EndIf
            local0 = (local0 - local5\Field44)
            If (local5\Field45 <> 0) Then
                local2 = (- local2)
            EndIf
    End Select
    If (((arg0\Field37 <> $00) And (arg0\Field17 <> $00)) <> 0) Then
        rotateentity(arg0\Field17, (entitypitch(arg0\Field17, $00) + local1), entityyaw(arg0\Field17, $01), (entityroll(arg0\Field17, $01) + arg0\Field98), $01)
    EndIf
    rotateentity(arg0\Field15, local2, local0, getplayerheadoffset(arg0\Field0), $01)
    Return $00
End Function
