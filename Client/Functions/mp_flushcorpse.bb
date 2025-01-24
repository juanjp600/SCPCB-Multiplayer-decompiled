Function mp_flushcorpse%(arg0.mp_playercorpse)
    Local local0%
    If (arg0\Field5 > $00) Then
        For local0 = $00 To (arg0\Field5 - $01) Step $01
            If (arg0\Field6[local0] <> Null) Then
                positionentity(arg0\Field6[local0]\Field2, entityx(arg0\Field1, $01), (entityy(arg0\Field1, $01) + 0.1), entityz(arg0\Field1, $01), $01)
                resetentity(arg0\Field6[local0]\Field2)
                arg0\Field6[local0]\Field15 = $00
                arg0\Field6[local0]\Field24 = $00
            EndIf
        Next
    EndIf
    freeentity(arg0\Field2)
    arg0\Field2 = $00
    Delete arg0
    Return $00
End Function
