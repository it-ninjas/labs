export interface Bicycle {
    name: string;
    url: string;
  }
  
  export interface BicycleImage {
    displayLink: string;
    fileFormat: string;
    htmlSnippet: string;
    htmlTitle: string;
    image: {
      byteSize: number;
      contextLink: string;
      height: number;
      thumbnailHeight: number;
      thumbnailLink: string;
      thumbnailWidth: number;
      width: number;
    };
    kind: string;
    link: string;
    mime: string;
    snippet: string;
    title: string;
  }
  
  export interface GoogleCustomSearchResponse {
    kind: string;
    url: {
      type: string;
      template: string;
    };
    queries: {
      request: {
        count: number;
        cx: string;
        inputEncoding: string;
        outputEncoding: string;
        safe: string;
        searchTerms: string;
        searchType: string;
        startIndex: number;
        title: string;
        totalResults: string;
      }[];
      nextPage: {
        count: number;
        cx: string;
        inputEncoding: string;
        outputEncoding: string;
        safe: string;
        searchTerms: string;
        searchType: string;
        startIndex: number;
        title: string;
        totalResults: string;
      }[];
    };
    searchInformation: {
      searchTime: number;
      formattedSearchTime: string;
      totalResults: string;
      formattedTotalResults: string;
    };
    items: BicycleImage[];
    context?: {
      title: string;
    };
  }