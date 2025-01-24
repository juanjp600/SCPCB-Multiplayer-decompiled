Function mp_explorecorpse%(arg0.mp_playercorpse)
    Local local0%
    If (arg0\Field14 <> 0) Then
        Return $00
    EndIf
    If (mp_ishoster() <> 0) Then
        arg0\Field11 = $00
        arg0\Field14 = $01
        For local0 = $00 To $09 Step $01
            If (arg0\Field6[local0] <> Null) Then
                positionentity(arg0\Field6[local0]\Field2, entityx(arg0\Field1, $01), (entityy(arg0\Field1, $01) + 0.1), entityz(arg0\Field1, $01), $01)
                resetentity(arg0\Field6[local0]\Field2)
                arg0\Field6[local0]\Field24 = $00
                arg0\Field6[local0]\Field15 = $00
                arg0\Field6[local0] = Null
            EndIf
        Next
        For local0 = $00 To $09 Step $01
            mp_setcorpseattachmodel(arg0, local0, Null)
        Next
        If (arg0\Field15 > $00) Then
            mp_setcorpsemodel(arg0, entityx(arg0\Field2, $00), entityy(arg0\Field2, $00), entityz(arg0\Field2, $00), entityyaw(arg0\Field2, $00), arg0\Field15, arg0\Field16)
        EndIf
        If (2100.0 < arg0\Field10) Then
            arg0\Field10 = 2100.0
        EndIf
    Else
        mp_client_explorecorpse(arg0)
    EndIf
    Return $00
End Function
