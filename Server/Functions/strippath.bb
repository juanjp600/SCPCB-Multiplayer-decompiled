Function strippath$(arg0$)
    Local local0$
    Local local1%
    Local local2$
    local0 = ""
    If (len(arg0) > $00) Then
        local1 = len(arg0)
        While (local1 >= $01)
            local2 = mid(arg0, local1, $01)
            If (((local2 = "\") Or (local2 = "/")) <> 0) Then
                Return local0
            EndIf
            local0 = (local2 + local0)
            local1 = (local1 + $FFFFFFFF)
        Wend
    EndIf
    Return local0
    Return ""
End Function
