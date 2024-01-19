Function updateparticles_devil%()
    Local local0.emitter
    Local local1%
    For local0 = Each emitter
        freeentity(local0\Field6)
        If ((local0\Field0 And local0\Field5) <> 0) Then
            freeentity(local0\Field5)
        EndIf
        Delete local0
    Next
    Return $00
End Function
