Function stripdirectorypath$(arg0$, arg1$)
    Local local0$
    Local local1%
    Local local2$
    Local local3%
    Local local4$
    local0 = ""
    If (len(arg0) > $00) Then
        local3 = len(arg0)
        While (local3 >= $01)
            local4 = mid(arg0, local3, $01)
            If (((local4 = "\") Or (local4 = "/")) <> 0) Then
                If (local2 = arg1) Then
                    Return local0
                EndIf
                local2 = ""
            EndIf
            local2 = (local4 + local2)
            local0 = (local4 + local0)
            local3 = (local3 + $FFFFFFFF)
        Wend
    EndIf
    Return local0
    Return ""
End Function
