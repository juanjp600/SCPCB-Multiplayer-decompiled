Function mp_getvoicebuffer%()
    If (((mp_getvoicerecording() = $00) Lor (banksize(mp_voice\Field3) = $00)) <> 0) Then
        Return $00
    EndIf
    Return mp_voice\Field3
    Return $00
End Function
