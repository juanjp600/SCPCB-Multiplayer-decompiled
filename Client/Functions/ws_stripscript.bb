Function ws_stripscript$(arg0$)
    Local local0%
    Local local1$
    Local local2%
    Local local3$
    Local local4%
    local0 = $00
    local0 = countchars(arg0, "\")
    If (local0 = $00) Then
        local0 = countchars(arg0, "/")
    EndIf
    For local4 = $01 To len(arg0) Step $01
        local3 = mid(arg0, local4, $01)
        local1 = (local1 + local3)
        If (((local3 = "\") Or (local3 = "/")) <> 0) Then
            local2 = (local2 + $01)
        EndIf
        If (local2 = local0) Then
            Exit
        EndIf
    Next
    Return left(local1, (Int max((Float (len(local1) - $01)), 0.0)))
    Return ""
End Function
