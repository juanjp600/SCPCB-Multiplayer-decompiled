Function writeelevators%()
    Local local0.doors
    For local0 = Each doors
        If (local0\Field23 > $00) Then
            udp_writeshort(local0\Field18)
            udp_writebyte((((local0\Field5 + (local0\Field4 Shl $01)) + ((local0\Field35 <> $00) Shl $02)) + ((local0\Field36 <> $00) Shl $03)))
            udp_writefloat(local0\Field29)
            If (local0\Field35 <> 0) Then
                udp_writebyte(local0\Field12)
            EndIf
            If (local0\Field36 <> 0) Then
                udp_writebyte((local0\Field17 <> ""))
            EndIf
        EndIf
    Next
    Return $00
End Function
