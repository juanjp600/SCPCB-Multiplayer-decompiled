Function setemitter%(arg0%, arg1%, arg2%, arg3%)
    Local local0.emitter
    Local local1%
    local0 = (New emitter)
    If (arg2 <> 0) Then
        local0\Field5 = createpivot($00)
        positionentity(local0\Field5, entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00), $00)
        local0\Field0 = $01
    Else
        local0\Field5 = arg0
    EndIf
    local0\Field6 = createmesh($00)
    nameentity(local0\Field6, "Emitter3")
    local0\Field7 = createsurface(local0\Field6, $00)
    local0\Field4 = (Object.template arg1)
    local0\Field3 = (Float local0\Field4\Field5)
    entityblend(local0\Field6, local0\Field4\Field1)
    entityfx(local0\Field6, $22)
    If (local0\Field4\Field8 <> 0) Then
        entitytexture(local0\Field6, local0\Field4\Field8, $00, $00)
    EndIf
    For local1 = $00 To $07 Step $01
        If (local0\Field4\Field0[local1] <> Null) Then
            If (local0\Field4\Field0[local1]\Field8 <> 0) Then
                setemitter(arg0, (Handle local0\Field4\Field0[local1]), arg2, $00)
            EndIf
        EndIf
    Next
    Return local0\Field6
    Return $00
End Function
