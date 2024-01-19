Function version$(arg0%)
    Return (((((Str ((arg0 Shr $10) And $FF)) + ".") + (Str ((arg0 Shr $08) And $FF))) + ".") + (Str ((arg0 Shr $00) And $FF)))
    Return ""
End Function
