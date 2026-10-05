Function serversafetext$(arg0$, arg1%)
    Local local0$
    Local local1$
    Local local2%
    Local local3%
    local0 = ""
    For local3 = $01 To len(arg0) Step $01
        If (len(local0) >= arg1) Then
            Exit
        EndIf
        local1 = mid(arg0, local3, $01)
        local2 = asc(local1)
        If (((local2 >= $20) And (local2 <= $7E)) <> 0) Then
            local0 = (local0 + local1)
        EndIf
    Next
    Return trim(local0)
    Return ""
End Function
