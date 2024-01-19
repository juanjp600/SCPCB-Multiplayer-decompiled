Function freeemitter%(arg0%, arg1%)
    Local local0.emitter
    Local local1.particle
    For local0 = Each emitter
        If (local0\Field5 = arg0) Then
            If (arg1 <> 0) Then
                For local1 = Each particle
                    If (local1\Field0 = local0) Then
                        Delete local1
                    EndIf
                Next
                freeentity(local0\Field6)
                If ((local0\Field0 And local0\Field5) <> 0) Then
                    freeentity(local0\Field5)
                EndIf
                Delete local0
            Else
                local0\Field8 = $01
            EndIf
        EndIf
    Next
    Return $00
End Function
