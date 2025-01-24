Function mp_setcorpsemodel%(arg0.mp_playercorpse, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0.mp_modelmeshpreset
    Local local1%
    Local local2#
    Local local3%
    Local local4%
    local0 = getplayermodelmeshpreset(arg5)
    If (local0 = Null) Then
        Return $00
    EndIf
    local1 = $FFFFFFFF
    local2 = 1.0
    If (arg0\Field2 <> $00) Then
        local2 = animtime(arg0\Field2)
        local1 = arg0\Field9
        For local3 = $00 To $09 Step $01
            mp_setcorpseattachmodel(arg0, local3, Null)
        Next
        freeentity(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    arg0\Field2 = copyentity(getplayermodelmesh(arg5), $00)
    If (getplayermodelterminatedtexture(arg6) <> $00) Then
        entitytexture(arg0\Field2, getplayermodelterminatedtexture(arg6), $00, $00)
    EndIf
    positionentity(arg0\Field2, arg1, arg2, arg3, $00)
    rotateentity(arg0\Field2, 0.0, arg4, 0.0, $00)
    scaleentity(arg0\Field2, local0\Field11, local0\Field11, local0\Field11, $01)
    arg0\Field1 = createpivot(arg0\Field2)
    translateentity(arg0\Field1, 0.0, 0.05, 0.0, $00)
    entityradius(arg0\Field1, 0.01, 0.0)
    entitypickmode(arg0\Field1, $01, $01)
    If (local1 <> $FFFFFFFF) Then
        local4 = local0\Field25[local1]
        If (local4 <> $00) Then
            extractanimseq(arg0\Field2, getfirstpackedvalue(local4), getsecondpackedvalue(local4), $00)
            animate(arg0\Field2, $03, 200.0, $01, 0.0)
        Else
            setanimtime(arg0\Field2, local2, $00)
        EndIf
    EndIf
    arg0\Field3 = arg5
    arg0\Field4 = arg6
    Return $01
    Return $00
End Function
