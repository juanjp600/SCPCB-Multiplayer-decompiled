Function mp_getvoicetime#(arg0%)
    If (mp_voice = Null) Then
        Return 0.0
    EndIf
    Return (((Float arg0) / (Float opus_get_sample_rate())) / 2.0)
    Return 0.0
End Function
