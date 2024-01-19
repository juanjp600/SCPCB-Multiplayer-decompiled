Function freeparticles%()
    Local local0.template
    Local local1.emitter
    For local0 = Each template
        freetemplate((Handle local0))
    Next
    For local1 = Each emitter
        freeemitter(local1\Field6, $01)
    Next
    Delete Each template
    Delete Each emitter
    Delete Each particle
    If (particlepiv <> 0) Then
        freeentity(particlepiv)
    EndIf
    Return $00
End Function
