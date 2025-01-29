Function mp_setcorpseattachmodel%(arg0.mp_playercorpse, arg1%, arg2.mp_attachmodel)
    Local local0.mp_attachmodelpreset
    Local local1%
    If (arg0\Field7[arg1] = arg2) Then
        Return $00
    EndIf
    If (arg0\Field8[arg1] <> $00) Then
        arg0\Field12 = (arg0\Field12 - $01)
        freeentity(arg0\Field8[arg1])
        arg0\Field8[arg1] = $00
        arg0\Field7[arg1] = Null
    EndIf
    If (arg2 = Null) Then
        Return $00
    EndIf
    local0 = arg2\Field9[arg0\Field3]
    If (((local0 = Null) Lor (arg2\Field3[local0\Field8] = $00)) <> 0) Then
        Return $00
    EndIf
    local1 = findchild(arg0\Field2, local0\Field0)
    If (local1 = $00) Then
        Return $00
    EndIf
    arg0\Field7[arg1] = arg2
    arg0\Field8[arg1] = copyentity(arg0\Field7[arg1]\Field3[local0\Field8], local1)
    positionentity(arg0\Field8[arg1], local0\Field4, local0\Field5, local0\Field6, $00)
    rotateentity(arg0\Field8[arg1], local0\Field1, local0\Field2, local0\Field3, $00)
    scaleentity(arg0\Field8[arg1], local0\Field7, local0\Field7, local0\Field7, $00)
    If (arg0\Field7[arg1]\Field4[local0\Field8] <> $00) Then
        entitytexture(arg0\Field8[arg1], arg0\Field7[arg1]\Field4[local0\Field8], $00, $00)
    EndIf
    arg0\Field12 = (arg0\Field12 + $01)
    Return $00
End Function
