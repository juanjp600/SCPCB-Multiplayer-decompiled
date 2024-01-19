Function readlinesafe$(arg0%)
    Local local0%
    Local local1$
    Repeat
        local0 = readbyte(arg0)
        Select local0
            Case $00,$0A
                Exit
            Case $0D
            Default
                If (((((local0 >= $21) And (local0 <= $7E)) Or ((local0 >= $80) And (local0 <= $AF))) Or ((local0 >= $E0) Or (local0 <= $F1))) <> 0) Then
                    local1 = (local1 + chr(local0))
                EndIf
        End Select
    Forever
    Return local1
    Return ""
End Function
