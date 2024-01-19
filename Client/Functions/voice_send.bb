Function voice_send%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (arg1 = $00) Then
        local0 = (opus_get_default_frame_size() Shl $01)
        local1 = createbank(local0)
        For local2 = $00 To ((banksize(arg0) / local0) - $01) Step $01
            copybank(arg0, (local0 * local2), local1, $00, local0)
            local3 = opus_pcm_encode(local1)
            If (((local3 <> $FFFFFFFF) And (local3 <> $00)) <> 0) Then
                udp_writebyte($1D)
                udp_writebyte(networkserver\Field28)
                udp_writebytes(local3, $00, banksize(local3))
                udp_sendmessage($00)
                freebank(local3)
            EndIf
        Next
        freebank(local1)
    Else
        udp_writebyte($7B)
        udp_writebyte(networkserver\Field28)
        udp_sendmessage($00)
    EndIf
    Return $00
End Function
