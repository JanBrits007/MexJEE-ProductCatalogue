
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Currency_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Currency_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="AUD"/>
 *     &lt;enumeration value="CHF"/>
 *     &lt;enumeration value="DKK"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="NOK"/>
 *     &lt;enumeration value="RUR"/>
 *     &lt;enumeration value="SEK"/>
 *     &lt;enumeration value="INR"/>
 *     &lt;enumeration value="AED"/>
 *     &lt;enumeration value="AFN"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="AMD"/>
 *     &lt;enumeration value="ANG"/>
 *     &lt;enumeration value="AOA"/>
 *     &lt;enumeration value="ARS"/>
 *     &lt;enumeration value="AWG"/>
 *     &lt;enumeration value="AZN"/>
 *     &lt;enumeration value="BAM"/>
 *     &lt;enumeration value="BBD"/>
 *     &lt;enumeration value="BDT"/>
 *     &lt;enumeration value="BGN"/>
 *     &lt;enumeration value="BHD"/>
 *     &lt;enumeration value="BIF"/>
 *     &lt;enumeration value="BMD"/>
 *     &lt;enumeration value="BND"/>
 *     &lt;enumeration value="BOB"/>
 *     &lt;enumeration value="BOV"/>
 *     &lt;enumeration value="BRL"/>
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="BTN"/>
 *     &lt;enumeration value="BWP"/>
 *     &lt;enumeration value="BYR"/>
 *     &lt;enumeration value="BZD"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CDF"/>
 *     &lt;enumeration value="CHE"/>
 *     &lt;enumeration value="CLF"/>
 *     &lt;enumeration value="CLP"/>
 *     &lt;enumeration value="CNY"/>
 *     &lt;enumeration value="COP"/>
 *     &lt;enumeration value="COU"/>
 *     &lt;enumeration value="CRC"/>
 *     &lt;enumeration value="CUC"/>
 *     &lt;enumeration value="CUP"/>
 *     &lt;enumeration value="CVE"/>
 *     &lt;enumeration value="CZK"/>
 *     &lt;enumeration value="DJF"/>
 *     &lt;enumeration value="DOP"/>
 *     &lt;enumeration value="DZD"/>
 *     &lt;enumeration value="EGP"/>
 *     &lt;enumeration value="ERN"/>
 *     &lt;enumeration value="ETB"/>
 *     &lt;enumeration value="FJD"/>
 *     &lt;enumeration value="FKP"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="GEL"/>
 *     &lt;enumeration value="GHS"/>
 *     &lt;enumeration value="GIP"/>
 *     &lt;enumeration value="GMD"/>
 *     &lt;enumeration value="GNF"/>
 *     &lt;enumeration value="GTQ"/>
 *     &lt;enumeration value="GYD"/>
 *     &lt;enumeration value="HKD"/>
 *     &lt;enumeration value="HNL"/>
 *     &lt;enumeration value="HTG"/>
 *     &lt;enumeration value="HUF"/>
 *     &lt;enumeration value="IDR"/>
 *     &lt;enumeration value="ILS"/>
 *     &lt;enumeration value="IQD"/>
 *     &lt;enumeration value="IRR"/>
 *     &lt;enumeration value="ISK"/>
 *     &lt;enumeration value="JMD"/>
 *     &lt;enumeration value="JOD"/>
 *     &lt;enumeration value="KES"/>
 *     &lt;enumeration value="KGS"/>
 *     &lt;enumeration value="KHR"/>
 *     &lt;enumeration value="KMF"/>
 *     &lt;enumeration value="KPW"/>
 *     &lt;enumeration value="KRW"/>
 *     &lt;enumeration value="KWD"/>
 *     &lt;enumeration value="KYD"/>
 *     &lt;enumeration value="KZT"/>
 *     &lt;enumeration value="LAK"/>
 *     &lt;enumeration value="LBP"/>
 *     &lt;enumeration value="LKR"/>
 *     &lt;enumeration value="LRD"/>
 *     &lt;enumeration value="LSL"/>
 *     &lt;enumeration value="LTL"/>
 *     &lt;enumeration value="LVL"/>
 *     &lt;enumeration value="LYD"/>
 *     &lt;enumeration value="MAD"/>
 *     &lt;enumeration value="MDL"/>
 *     &lt;enumeration value="MGA"/>
 *     &lt;enumeration value="MKD"/>
 *     &lt;enumeration value="MMK"/>
 *     &lt;enumeration value="MNT"/>
 *     &lt;enumeration value="MOP"/>
 *     &lt;enumeration value="MRO"/>
 *     &lt;enumeration value="MUR"/>
 *     &lt;enumeration value="MVR"/>
 *     &lt;enumeration value="MWK"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="MXV"/>
 *     &lt;enumeration value="MYR"/>
 *     &lt;enumeration value="MZN"/>
 *     &lt;enumeration value="NAD"/>
 *     &lt;enumeration value="NGN"/>
 *     &lt;enumeration value="NIO"/>
 *     &lt;enumeration value="NPR"/>
 *     &lt;enumeration value="NZD"/>
 *     &lt;enumeration value="OMR"/>
 *     &lt;enumeration value="PAB"/>
 *     &lt;enumeration value="PEN"/>
 *     &lt;enumeration value="PGK"/>
 *     &lt;enumeration value="PHP"/>
 *     &lt;enumeration value="PKR"/>
 *     &lt;enumeration value="PLN"/>
 *     &lt;enumeration value="PYG"/>
 *     &lt;enumeration value="QAR"/>
 *     &lt;enumeration value="RON"/>
 *     &lt;enumeration value="RSD"/>
 *     &lt;enumeration value="RUB"/>
 *     &lt;enumeration value="RWF"/>
 *     &lt;enumeration value="SAR"/>
 *     &lt;enumeration value="SBD"/>
 *     &lt;enumeration value="SCR"/>
 *     &lt;enumeration value="SDG"/>
 *     &lt;enumeration value="SGD"/>
 *     &lt;enumeration value="SHP"/>
 *     &lt;enumeration value="SLL"/>
 *     &lt;enumeration value="SOS"/>
 *     &lt;enumeration value="SRD"/>
 *     &lt;enumeration value="STD"/>
 *     &lt;enumeration value="SYP"/>
 *     &lt;enumeration value="SZL"/>
 *     &lt;enumeration value="THB"/>
 *     &lt;enumeration value="TJS"/>
 *     &lt;enumeration value="TMT"/>
 *     &lt;enumeration value="TND"/>
 *     &lt;enumeration value="TOP"/>
 *     &lt;enumeration value="TRY"/>
 *     &lt;enumeration value="TTD"/>
 *     &lt;enumeration value="TWD"/>
 *     &lt;enumeration value="TZS"/>
 *     &lt;enumeration value="UAH"/>
 *     &lt;enumeration value="UGX"/>
 *     &lt;enumeration value="USN"/>
 *     &lt;enumeration value="USS"/>
 *     &lt;enumeration value="UYU"/>
 *     &lt;enumeration value="UZS"/>
 *     &lt;enumeration value="VEF"/>
 *     &lt;enumeration value="VND"/>
 *     &lt;enumeration value="VUV"/>
 *     &lt;enumeration value="WST"/>
 *     &lt;enumeration value="XAF"/>
 *     &lt;enumeration value="XAG"/>
 *     &lt;enumeration value="XAU"/>
 *     &lt;enumeration value="XBA"/>
 *     &lt;enumeration value="XBB"/>
 *     &lt;enumeration value="XBC"/>
 *     &lt;enumeration value="XBD"/>
 *     &lt;enumeration value="XCD"/>
 *     &lt;enumeration value="XDR"/>
 *     &lt;enumeration value="XFU"/>
 *     &lt;enumeration value="XOF"/>
 *     &lt;enumeration value="XPD"/>
 *     &lt;enumeration value="XPF"/>
 *     &lt;enumeration value="XPT"/>
 *     &lt;enumeration value="XTS"/>
 *     &lt;enumeration value="XXX"/>
 *     &lt;enumeration value="YER"/>
 *     &lt;enumeration value="ZAR"/>
 *     &lt;enumeration value="ZMK"/>
 *     &lt;enumeration value="ZWL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Currency_Type")
@XmlEnum
public enum CurrencyType {


    /**
     * 
     * US dollar
     * 
     */
    USD,

    /**
     * 
     * Euro 
     * 
     */
    EUR,

    /**
     * 
     * Australian dollar
     * 
     */
    AUD,

    /**
     * 
     * Swiss franc 
     * 
     */
    CHF,

    /**
     * 
     * Danish krone 
     * 
     */
    DKK,

    /**
     * 
     * Japanese yen
     * 
     */
    JPY,

    /**
     * 
     * Norwegian crown
     * 
     */
    NOK,

    /**
     * 
     * Russian ruble
     * 
     */
    RUR,

    /**
     * 
     * Swedish crown
     * 
     */
    SEK,

    /**
     * 
     * Indian rupee 
     * 
     */
    INR,

    /**
     * 
     * United Arab Emirates dirham
     * 
     */
    AED,

    /**
     * 
     * Afghan afghani 
     * 
     */
    AFN,

    /**
     * 
     * Albanian lek 
     * 
     */
    ALL,

    /**
     * 
     * Armenian dram 
     * 
     */
    AMD,

    /**
     * 
     * Netherlands Antillean guilder
     * 
     */
    ANG,

    /**
     * 
     * Angolan kwanza 
     * 
     */
    AOA,

    /**
     * 
     * Argentine peso 
     * 
     */
    ARS,

    /**
     * 
     * Aruban florin 
     * 
     */
    AWG,

    /**
     * 
     * Azerbaijani manat 
     * 
     */
    AZN,

    /**
     * 
     * Bosnia and Herzegovina convertible mark 
     * 
     */
    BAM,

    /**
     * 
     * Barbados dollar 
     * 
     */
    BBD,

    /**
     * 
     * Bangladeshi taka 
     * 
     */
    BDT,
    BGN,

    /**
     * 
     * Bahraini dinar 
     * 
     */
    BHD,

    /**
     * 
     * Burundian franc 
     * 
     */
    BIF,

    /**
     * 
     * customarily known as Bermuda dollar
     * 
     */
    BMD,

    /**
     * 
     * Brunei dollar 
     * 
     */
    BND,

    /**
     * 
     * Boliviano 
     * 
     */
    BOB,

    /**
     * 
     * Bolivian Mvdol (funds code)
     * 
     */
    BOV,

    /**
     * 
     * Brazilian real 
     * 
     */
    BRL,

    /**
     * 
     * Bahamian dollar 
     * 
     */
    BSD,

    /**
     * 
     * Bhutanese ngultrum 
     * 
     */
    BTN,

    /**
     * 
     * Botswana pula 
     * 
     */
    BWP,

    /**
     * 
     * Belarusian ruble
     * 
     */
    BYR,

    /**
     * 
     * Belize dollar 
     * 
     */
    BZD,

    /**
     * 
     * Canadian dollar 
     * 
     */
    CAD,

    /**
     * 
     * Congolese franc (Democratic Republic of Congo) 
     * 
     */
    CDF,

    /**
     * 
     * WIR Bank (Switzerland) complementary currency
     * 
     */
    CHE,

    /**
     * 
     * Unidad de Fomento (funds code) Chile 
     * 
     */
    CLF,

    /**
     * 
     * Chilean peso, Chile 
     * 
     */
    CLP,

    /**
     * 
     * Chinese yuan 
     * 
     */
    CNY,

    /**
     * 
     * Colombian peso 
     * 
     */
    COP,

    /**
     * 
     * Unidad de Valor Real (Colombia)
     * 
     */
    COU,

    /**
     * 
     * Costa Rican colon 
     * 
     */
    CRC,

    /**
     * 
     * Cuban convertible peso
     * 
     */
    CUC,

    /**
     * 
     * Cuban peso 
     * 
     */
    CUP,

    /**
     * 
     * Cape Verde escudo 
     * 
     */
    CVE,

    /**
     * 
     * Czech koruna 
     * 
     */
    CZK,

    /**
     * 
     * Djiboutian franc 
     * 
     */
    DJF,

    /**
     * 
     * Dominican peso 
     * 
     */
    DOP,

    /**
     * 
     * Algerian dinar 
     * 
     */
    DZD,

    /**
     * 
     * Egyptian pound
     * 
     */
    EGP,

    /**
     * 
     * Eritrean nakfa 
     * 
     */
    ERN,

    /**
     * 
     * Ethiopian birr 
     * 
     */
    ETB,

    /**
     * 
     * Fiji dollar 
     * 
     */
    FJD,

    /**
     * 
     * Falkland Islands pound
     * 
     */
    FKP,

    /**
     * 
     * Pound sterling 
     * 
     */
    GBP,

    /**
     * 
     * Georgian lari 
     * 
     */
    GEL,

    /**
     * 
     * Ghanaian cedi 
     * 
     */
    GHS,

    /**
     * 
     * Gibraltar pound 
     * 
     */
    GIP,

    /**
     * 
     * Gambian dalasi 
     * 
     */
    GMD,

    /**
     * 
     * Guinean franc 
     * 
     */
    GNF,

    /**
     * 
     * Guatemalan quetzal 
     * 
     */
    GTQ,

    /**
     * 
     * Guyanese dollar 
     * 
     */
    GYD,

    /**
     * 
     * Hong Kong dollar 
     * 
     */
    HKD,

    /**
     * 
     * Honduran lempira 
     * 
     */
    HNL,

    /**
     * 
     * Haitian gourde 
     * 
     */
    HTG,

    /**
     * 
     * Hungarian forint 
     * 
     */
    HUF,

    /**
     * 
     * Indonesian rupiah 
     * 
     */
    IDR,

    /**
     * 
     * Israeli new sheqel 
     * 
     */
    ILS,

    /**
     * 
     * Iraqi dinar
     * 
     */
    IQD,

    /**
     * 
     * Iranian rial 
     * 
     */
    IRR,

    /**
     * 
     * Icelandic króna 
     * 
     */
    ISK,

    /**
     * 
     * Jamaican dollar 
     * 
     */
    JMD,

    /**
     * 
     * Jordanian dinar 
     * 
     */
    JOD,

    /**
     * 
     * Kenyan shilling 
     * 
     */
    KES,

    /**
     * 
     * Kyrgyzstani som (Kyrgyzstan)
     * 
     */
    KGS,
    KHR,

    /**
     * 
     * Comoro franc 
     * 
     */
    KMF,

    /**
     * 
     * North Korean won 
     * 
     */
    KPW,

    /**
     * 
     * South Korean won 
     * 
     */
    KRW,

    /**
     * 
     * Kuwaiti dinar 
     * 
     */
    KWD,

    /**
     * 
     * Cayman Islands dollar
     * 
     */
    KYD,

    /**
     * 
     * Kazakhstani tenge 
     * 
     */
    KZT,

    /**
     * 
     * Lao kip (Laos)
     * 
     */
    LAK,

    /**
     * 
     * Lebanese pound 
     * 
     */
    LBP,

    /**
     * 
     * Sri Lanka rupee
     * 
     */
    LKR,

    /**
     * 
     * Liberian dollar 
     * 
     */
    LRD,

    /**
     * 
     * Lesotho loti
     * 
     */
    LSL,

    /**
     * 
     * Lithuanian litas 
     * 
     */
    LTL,

    /**
     * 
     * Latvian lats 
     * 
     */
    LVL,

    /**
     * 
     * Libyan dinar 
     * 
     */
    LYD,

    /**
     * 
     * Moroccan dirham 
     * 
     */
    MAD,

    /**
     * 
     * Moldovan leu 
     * 
     */
    MDL,

    /**
     * 
     * Malagasy ariary 
     * 
     */
    MGA,

    /**
     * 
     * Macedonian denar
     * 
     */
    MKD,

    /**
     * 
     * Myanma kyat 
     * 
     */
    MMK,

    /**
     * 
     * Mongolian tugrik 
     * 
     */
    MNT,

    /**
     * 
     * Macanese pataca 
     * 
     */
    MOP,

    /**
     * 
     * Mauritanian ouguiya 
     * 
     */
    MRO,

    /**
     * 
     * Mauritian rupee 
     * 
     */
    MUR,

    /**
     * 
     * Maldivian rufiyaa 
     * 
     */
    MVR,

    /**
     * 
     * Malawian kwacha 
     * 
     */
    MWK,

    /**
     * 
     * Mexican peso 
     * 
     */
    MXN,

    /**
     * 
     * Mexican Unidad de Inversion 
     * 
     */
    MXV,

    /**
     * 
     * Malaysian ringgit 
     * 
     */
    MYR,

    /**
     * 
     * Mozambican metical 
     * 
     */
    MZN,

    /**
     * 
     * Namibian dollar
     * 
     */
    NAD,

    /**
     * 
     * Nigerian naira 
     * 
     */
    NGN,

    /**
     * 
     * Cordoba oro 
     * 
     */
    NIO,

    /**
     * 
     * Nepalese rupee 
     * 
     */
    NPR,

    /**
     * 
     * New Zealand dollar Cook Islands , New Zealand, Pitcairn , Tokelau, Niue
     * 
     */
    NZD,

    /**
     * 
     * Omani rial 
     * 
     */
    OMR,

    /**
     * 
     * Panamanian balboa 
     * 
     */
    PAB,

    /**
     * 
     * Peruvian nuevo sol 
     * 
     */
    PEN,

    /**
     * 
     * Papua New Guinean kina 
     * 
     */
    PGK,

    /**
     * 
     * Philippine peso 
     * 
     */
    PHP,

    /**
     * 
     * Pakistani rupee
     * 
     */
    PKR,

    /**
     * 
     * Polish zloty 
     * 
     */
    PLN,

    /**
     * 
     * Paraguayan guaraní 
     * 
     */
    PYG,

    /**
     * 
     * Qatari rial 
     * 
     */
    QAR,

    /**
     * 
     * Romanian new leu 
     * 
     */
    RON,

    /**
     * 
     * Serbian dinar 
     * 
     */
    RSD,

    /**
     * 
     * Russian rouble
     * 
     */
    RUB,

    /**
     * 
     * Rwandan franc 
     * 
     */
    RWF,

    /**
     * 
     * Saudi riyal 
     * 
     */
    SAR,

    /**
     * 
     * Solomon Islands dollar 
     * 
     */
    SBD,

    /**
     * 
     * Seychelles rupee 
     * 
     */
    SCR,

    /**
     * 
     * Sudanese pound 
     * 
     */
    SDG,

    /**
     * 
     * Singapore dollar 
     * 
     */
    SGD,

    /**
     * 
     * Saint Helena pound 
     * 
     */
    SHP,

    /**
     * 
     * Sierra Leonean leone
     * 
     */
    SLL,

    /**
     * 
     * Somali shilling 
     * 
     */
    SOS,

    /**
     * 
     * Surinamese dollar 
     * 
     */
    SRD,

    /**
     * 
     * São Tomé and Príncipe dobra 
     * 
     */
    STD,

    /**
     * 
     * Syrian pound 
     * 
     */
    SYP,

    /**
     * 
     * Lilangeni 
     * 
     */
    SZL,

    /**
     * 
     * Thai baht (Thailand )
     * 
     */
    THB,

    /**
     * 
     * Tajikistani somoni 
     * 
     */
    TJS,

    /**
     * 
     * Turkmenistani manat 
     * 
     */
    TMT,

    /**
     * 
     * Tunisian dinar 
     * 
     */
    TND,

    /**
     * 
     * Tongan pa?anga 
     * 
     */
    TOP,

    /**
     * 
     * Turkish lira 
     * 
     */
    TRY,

    /**
     * 
     * Trinidad and Tobago dollar
     * 
     */
    TTD,

    /**
     * 
     * New Taiwan dollar (Taiwan and other islands that are under the effective control of the Republic of China) (ROC)
     * 
     */
    TWD,

    /**
     * 
     * Tanzanian shilling 
     * 
     */
    TZS,

    /**
     * 
     * Ukrainian hryvnia 
     * 
     */
    UAH,

    /**
     * 
     * Ugandan shilling
     * 
     */
    UGX,

    /**
     * 
     * United States dollar (next day) (funds code)
     * 
     */
    USN,

    /**
     * 
     * United States dollar (same day) (funds code) 
     * 
     */
    USS,

    /**
     * 
     * Uruguayan peso 
     * 
     */
    UYU,

    /**
     * 
     * Uzbekistan som 
     * 
     */
    UZS,

    /**
     * 
     * Venezuelan bolívar fuerte 
     * 
     */
    VEF,

    /**
     * 
     * Vietnamese d?ng (Vietnam )
     * 
     */
    VND,

    /**
     * 
     * Vanuatu vatu 
     * 
     */
    VUV,

    /**
     * 
     * Samoan tala 
     * 
     */
    WST,

    /**
     * 
     * CFA franc BEAC (Cameroon, Central_African_Republic, Republic of the Congo , Chad , Equatorial Guinea , Gabon )
     * 
     */
    XAF,

    /**
     * 
     * Silver (one troy ounce)
     * 
     */
    XAG,

    /**
     * 
     * Gold (one troy ounce)
     * 
     */
    XAU,

    /**
     * 
     * (EURCO) (bond market unit)
     * 
     */
    XBA,

    /**
     * 
     * (E.M.U.-6) (bond market unit)
     * 
     */
    XBB,

    /**
     * 
     * European Unit of Account 9 (E.U.A.-9) (bond market unit)
     * 
     */
    XBC,

    /**
     * 
     * European Unit of Account 17 (E.U.A.-17) (bond market unit)
     * 
     */
    XBD,

    /**
     * 
     * East Caribbean dollar 
     * 
     */
    XCD,

    /**
     * 
     * International Monetary Fund 
     * 
     */
    XDR,

    /**
     * 
     * International Union of Railways
     * 
     */
    XFU,

    /**
     * 
     * CFA Franc BCEAO 
     * 
     */
    XOF,

    /**
     * 
     * Palladium (one troy ounce) 
     * 
     */
    XPD,

    /**
     * 
     * CFP franc 
     * 
     */
    XPF,

    /**
     * 
     * Platinum (one troy ounce)
     * 
     */
    XPT,

    /**
     * 
     * Code reserved for testing purposes
     * 
     */
    XTS,

    /**
     * 
     * No currency
     * 
     */
    XXX,

    /**
     * 
     * Yemeni rial 
     * 
     */
    YER,

    /**
     * 
     * South African rand 
     * 
     */
    ZAR,

    /**
     * 
     * Zambian kwacha 
     * 
     */
    ZMK,

    /**
     * 
     * Zimbabwe dollar 
     * 
     */
    ZWL;

    public String value() {
        return name();
    }

    public static CurrencyType fromValue(String v) {
        return valueOf(v);
    }

}
