Function file_splitafterchar$(arg0$, arg1$)
    Local local0$
    Local local1%
    local0 = ""
    local1 = len(arg0)
    While (local1 >= $01)
        If (mid(arg0, local1, $01) = arg1) Then
            local0 = right(arg0, (len(arg0) - local1))
            Exit
        EndIf
        local1 = (local1 + $FFFFFFFF)
    Wend
    Return local0
    Return ""
End Function
