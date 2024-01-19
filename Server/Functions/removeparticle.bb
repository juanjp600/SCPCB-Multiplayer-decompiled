Function removeparticle%(arg0.particles)
    If (arg0 = Null) Then
        Return $00
    EndIf
    freeentity(arg0\Field0)
    freeentity(arg0\Field1)
    Delete arg0
    Return $00
End Function
