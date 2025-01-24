Function freeemitter%(arg0.emitter, arg1%)
    Local local0.particle
    If (arg1 <> 0) Then
        For local0 = Each particle
            If (local0\Field0 = arg0) Then
                Delete local0
            EndIf
        Next
        freeentity(arg0\Field7)
        arg0\Field7 = $00
        arg0\Field8 = $00
        freeentity(arg0\Field6)
        arg0\Field6 = $00
        stopchannel(arg0\Field12)
        arg0\Field12 = $00
        Delete arg0
    Else
        arg0\Field9 = $01
    EndIf
    Return $00
End Function
