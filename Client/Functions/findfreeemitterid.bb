Function findfreeemitterid%()
    Local local0.emitter
    Local local1%
    Local local2%
    local1 = $01
    Repeat
        local2 = $00
        For local0 = Each emitter
            If (local0\Field5 = local1) Then
                local2 = $01
                Exit
            EndIf
        Next
        If (local2 = $00) Then
            Return local1
        EndIf
        local1 = (local1 + $01)
    Forever
    Return $00
End Function
