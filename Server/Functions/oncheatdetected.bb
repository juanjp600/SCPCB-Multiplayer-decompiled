Function oncheatdetected%(arg0%, arg1%)
    If (getscripts() <> 0) Then
        public_inqueue($35, $00)
        public_addparam($00, (Str arg0), $01)
        public_addparam($00, (Str arg1), $01)
        callback($00)
    EndIf
    Return $00
End Function
