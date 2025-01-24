Function stripfilename$(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    local0 = $00
    local1 = len(arg0)
    If (local1 = $00) Then
        Return ""
    EndIf
    local2 = local1
    While (local2 >= $01)
        local3 = mid(arg0, local2, $01)
        If (((local3 = "\") Lor (local3 = "/")) <> 0) Then
            local0 = local2
            Exit
        EndIf
        local2 = (local2 + $FFFFFFFF)
    Wend
    Return left(arg0, local0)
    Return ""
End Function
