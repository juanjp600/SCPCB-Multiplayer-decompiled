Function forcesetemitterid%(arg0.emitter, arg1%)
    Local local0.emitter
    arg0\Field5 = arg1
    For local0 = Each emitter
        If (local0 <> arg0) Then
            If (local0\Field5 = arg1) Then
                local0\Field5 = findfreeemitterid()
            EndIf
        EndIf
    Next
    Return $00
End Function
